package com.quipv.app.Controllers;

import com.quipv.app.Helpers.GraphHelper;
import com.quipv.app.Helpers.UserHelper;
import com.quipv.app.Models.*;
import com.quipv.app.Repositories.EdgeRepository;
import com.quipv.app.Repositories.GraphNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class DataController {

    @Autowired
    GraphNodeRepository graphNodeRepository;

    @Autowired
    EdgeRepository edgeRepository;

    @GetMapping("/data/pid={pid}/minVal={minArrowWeight}")
    public @ResponseBody HashMap<String, Object> get(@PathVariable(value="minArrowWeight") String minArrowWeight, @PathVariable(value="pid") Integer pid) {
        Integer minWeight = Integer.parseInt(minArrowWeight);
        String username = UserHelper.getUserName();
        List<GraphNodeEntity> graphNodeEntities = new ArrayList<>();
        List<EdgeEntity> edgeEntities = new ArrayList<>();
        //TODO filter for projectId
        graphNodeRepository.findNodesForUserAndProject(username, pid).forEach(graphNodeEntities::add);
        edgeRepository.findEdgesForUserAndProject(username, pid).forEach(edgeEntities::add);
        List<GraphNodeWithoutNeighbours> vertices = graphNodeEntities.stream().map(node -> new GraphNodeWithoutNeighbours(node.getName(), node.getNodeIndex(), node.isDriver(), node.isChecked(), node.getX(), node.getY())).collect(Collectors.toList());
        List<Edge> edges = edgeEntities.stream().map(edge -> new Edge(edge.getSourceIndex(), edge.getDestinationIndex(), edge.getWeight())).collect(Collectors.toList());
        VisualisationGraph graph = new VisualisationGraph(vertices, edges);
        graph = GraphHelper.filterEdges(graph, minWeight);
        HashMap<String, Object> map = new HashMap<>();
        map.put("vertices", graph.getVertices());
        map.put("edgesList", graph.getEdges());

        return map;
    }

    @PostMapping("/storeGraphState/pid={pid}")
    public void storeGraphState(@RequestBody GraphNodeWithoutNeighbours[] nodes, @PathVariable(value="pid") Integer pid){

        String username = UserHelper.getUserName();
        List<GraphNodeEntity> graphNodeEntities = new ArrayList<>();
        //TODO filter for projectId
        graphNodeRepository.findNodesForUserAndProject(username,pid).forEach(graphNodeEntities::add);
        for(int i = 0; i<graphNodeEntities.size(); i++){
            final GraphNodeEntity graphNodeEntity = graphNodeEntities.get(i);
            GraphNodeWithoutNeighbours node = Arrays.stream(nodes).filter(n -> n.getId() == graphNodeEntity.getNodeIndex()).findAny().orElse(null);
            if(node != null){
                graphNodeEntities.get(i).setX(node.getX());
                graphNodeEntities.get(i).setY(node.getY());
            }
        }
        graphNodeRepository.saveAll(graphNodeEntities);

    }

    @PostMapping("/updateNodePosition/pid={pid}")
    public void updateNodePosition(@RequestBody GraphNodeWithoutNeighbours node, @PathVariable(value="pid") Integer pid){

        String username = UserHelper.getUserName();
        List<GraphNodeEntity> graphNodeEntities = new ArrayList<>();
        //TODO filter for projectId
        graphNodeRepository.findNodesForUserAndProject(username,pid).forEach(graphNodeEntities::add);
        GraphNodeEntity graphNodeEntity = graphNodeEntities.stream().filter(n -> n.getNodeIndex() == node.getId()).findAny().get();
        graphNodeEntity.setX(node.getX());
        graphNodeEntity.setY(node.getY());
        graphNodeRepository.save(graphNodeEntity);
    }

    @PostMapping("/updateNodeFilters/pid={pid}")
    public void updateNodeFilters(@RequestBody Integer index, @PathVariable(value="pid") Integer pid){
        GraphNodeEntity node = graphNodeRepository.findNodeByIndex(UserHelper.getUserName(), pid, index);
        node.setChecked(!node.isChecked());
        graphNodeRepository.save(node);
    }

}
