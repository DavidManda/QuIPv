package com.quipv.app.Controllers;

import com.quipv.app.Helpers.GraphHelper;
import com.quipv.app.Helpers.UserHelper;
import com.quipv.app.Models.*;
import com.quipv.app.Repositories.EdgeRepository;
import com.quipv.app.Repositories.GraphNodeRepository;
import com.quipv.app.Repositories.ProjectRepository;
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

    @GetMapping("/data/{pid}/{minArrowWeight}")
    public @ResponseBody HashMap<String, Object> get(@PathVariable(value="minArrowWeight") String minArrowWeight) {
        Integer minWeight = Integer.parseInt(minArrowWeight);
        String username = UserHelper.getUserName();
        List<GraphNodeEntity> graphNodeEntities = new ArrayList<>();
        List<EdgeEntity> edgeEntities = new ArrayList<>();
        //TODO filter for projectId
        graphNodeRepository.findNodesForUser(username).forEach(graphNodeEntities::add);
        edgeRepository.findEdgesForUser(username).forEach(edgeEntities::add);
        List<GraphNodeWithoutNeighbours> vertices = graphNodeEntities.stream().map(node -> new GraphNodeWithoutNeighbours(node.getName(), node.getIndex(), node.isDriver(), node.getX(), node.getY())).collect(Collectors.toList());
        List<Edge> edges = edgeEntities.stream().map(edge -> new Edge(edge.getSourceIndex(), edge.getDestinationIndex(), edge.getWeight())).collect(Collectors.toList());
        VisualisationGraph graph = new VisualisationGraph(vertices, edges);
        graph = GraphHelper.filterEdges(graph, minWeight);
        HashMap<String, Object> map = new HashMap<>();
        map.put("vertices", graph.getVertices());
        map.put("edgesList", graph.getEdges());

        return map;
    }

    @PostMapping("/storeGraphState")
    public void storeGraphState(@RequestBody GraphNodeWithoutNeighbours[] nodes){

        String username = UserHelper.getUserName();
        List<GraphNodeEntity> graphNodeEntities = new ArrayList<>();
        //TODO filter for projectId
        graphNodeRepository.findNodesForUser(username).forEach(graphNodeEntities::add);
        for(int i = 0; i<graphNodeEntities.size(); i++){
            final GraphNodeEntity graphNodeEntity = graphNodeEntities.get(i);
            GraphNodeWithoutNeighbours node = Arrays.stream(nodes).filter(n -> n.getId() == graphNodeEntity.getIndex()).findAny().orElse(null);
            if(node != null){
                graphNodeEntities.get(i).setX(node.getX());
                graphNodeEntities.get(i).setY(node.getY());
            }
        }
        graphNodeRepository.saveAll(graphNodeEntities);

    }

    @PostMapping("/updateNodePosition")
    public void updateNodePosition(@RequestBody GraphNodeWithoutNeighbours node){

        String username = UserHelper.getUserName();
        List<GraphNodeEntity> graphNodeEntities = new ArrayList<>();
        //TODO filter for projectId
        graphNodeRepository.findNodesForUser(username).forEach(graphNodeEntities::add);
        GraphNodeEntity graphNodeEntity = graphNodeEntities.stream().filter(n -> n.getIndex() == node.getId()).findAny().get();
        graphNodeEntity.setX(node.getX());
        graphNodeEntity.setY(node.getY());
        graphNodeRepository.save(graphNodeEntity);
    }

}
