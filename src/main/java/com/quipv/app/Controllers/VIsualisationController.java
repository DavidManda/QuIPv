package com.quipv.app.Controllers;

import com.quipv.app.Repositories.SankeyRepository;
import com.quipv.app.Helpers.GraphHelper;
import com.quipv.app.Repositories.MaintableRepository;
import com.quipv.app.Helpers.ProjectHelper;
import com.quipv.app.Models.Graph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class VIsualisationController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @Autowired
    MaintableRepository maintableRepository;

    @Autowired
    SankeyRepository sankeyRepository;

    @GetMapping("/visualisation")
    public String visualisation(Model model){
        Graph graph = GraphHelper.constructGraph(ProjectHelper.populate(maintableRepository,sankeyRepository));
        model.addAttribute("edges", graph.getEdges());
        model.addAttribute("vertices", graph.getVertices());
        return "visualisation";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }


}
