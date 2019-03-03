package com.quipv.app.Controllers;

import com.quipv.app.Helpers.GraphHelper;
import com.quipv.app.DBO.MaintableRepository;
import com.quipv.app.Helpers.ProjectHelper;
import com.quipv.app.Models.Graph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
public class DataController {

    @Autowired
    MaintableRepository maintableRepository;
    @GetMapping("/data")
    public HashMap<String, Object> get() {

        Graph graph = GraphHelper.constructGraph(ProjectHelper.populate(maintableRepository));
        HashMap<String, Object> map = new HashMap<>();
        map.put("vertices", GraphHelper.getListOfNodes(graph));
        map.put("edgesList", graph.getEdges());

        return map;
    }

}
