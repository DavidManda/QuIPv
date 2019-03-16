package com.quipv.app.Controllers;

import com.quipv.app.Helpers.UserHelper;
import com.quipv.app.Models.Project;
import com.quipv.app.Repositories.SankeyRepository;
import com.quipv.app.Helpers.GraphHelper;
import com.quipv.app.Repositories.MaintableRepository;
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

    @Autowired
    SankeyRepository sankeyRepository;

    @GetMapping("/data")
    public HashMap<String, Object> get() {
        String username = UserHelper.getUserName();
        Project project = ProjectHelper.populate(maintableRepository,sankeyRepository, username);
        Graph graph = new Graph();
        if(project != null){
            graph = GraphHelper.constructGraph(project);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("vertices", GraphHelper.getListOfNodes(graph));
        map.put("edgesList", graph.getEdges());

        return map;
    }

}
