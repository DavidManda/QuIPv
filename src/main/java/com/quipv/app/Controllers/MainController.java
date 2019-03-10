package com.quipv.app.Controllers;

import com.quipv.app.Models.User;
import com.quipv.app.Repositories.SankeyRepository;
import com.quipv.app.Helpers.GraphHelper;
import com.quipv.app.Repositories.MaintableRepository;
import com.quipv.app.Helpers.ProjectHelper;
import com.quipv.app.Models.Graph;
import com.quipv.app.Service.SecurityService;
import com.quipv.app.Service.UserService;
import com.quipv.app.Validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @Autowired
    MaintableRepository maintableRepository;

    @Autowired
    SankeyRepository sankeyRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(Model model, @ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        System.out.println(bindingResult.getAllErrors());
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult);
            return "redirect:/registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/";
    }


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
