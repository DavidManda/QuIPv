package com.quipv.app.Controllers;

import com.quipv.app.Helpers.UserHelper;
import com.quipv.app.Models.*;
import com.quipv.app.Repositories.EdgeRepository;
import com.quipv.app.Repositories.GraphNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class DataController {

    @Autowired
    GraphNodeRepository graphNodeRepository;

    @Autowired
    EdgeRepository edgeRepository;

    @GetMapping("/data")
    public HashMap<String, Object> get() {
        String username = UserHelper.getUserName();
        List<GraphNodeEntity> graphNodeEntities = new ArrayList<>();
        List<EdgeEntity> edgeEntities = new ArrayList<>();
        graphNodeRepository.findAll().forEach(graphNodeEntities::add);
        edgeRepository.findAll().forEach(edgeEntities::add);
        List<GraphNodeWithoutNeighbours> vertices = graphNodeEntities.stream().map(node -> new GraphNodeWithoutNeighbours(node.getName(), node.getIndex(), node.isDriver())).collect(Collectors.toList());
        List<Edge> edges = edgeEntities.stream().map(edge -> new Edge(edge.getSourceIndex(), edge.getDestinationIndex(), edge.getWeight())).collect(Collectors.toList());
        HashMap<String, Object> map = new HashMap<>();
        map.put("vertices", vertices);
        map.put("edgesList", edges);

        return map;
    }

}
