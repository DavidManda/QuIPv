package com.quipv.app.Controllers;

import com.quipv.app.Helpers.GraphHelper;
import com.quipv.app.Helpers.ProjectHelper;
import com.quipv.app.Models.Graph;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
public class DataController {

    @GetMapping("/data")
    public HashMap<String, Object> get() {
        Graph graph = GraphHelper.constructGraph(ProjectHelper.populate());
        HashMap<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("nodes", graph.getVertices());
        return map;
    }

}
