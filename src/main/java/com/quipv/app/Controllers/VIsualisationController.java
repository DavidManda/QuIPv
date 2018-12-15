package com.quipv.app.Controllers;

import com.quipv.app.Helpers.ProjectHelper;
import com.quipv.app.Models.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class VIsualisationController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/visualisation")
    public String visualisation(Model model){
        Project project = ProjectHelper.populate();
        model.addAttribute("project", project);
        return "visualisation";
    }


}
