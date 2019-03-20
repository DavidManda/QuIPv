package com.quipv.app.Controllers;

import com.quipv.app.Helpers.UserHelper;
import com.quipv.app.Models.ProjectEntity;
import com.quipv.app.Models.User;
import com.quipv.app.Repositories.ProjectRepository;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Controller
public class MainController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(Model model, @ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/registration?successful";
    }

    @GetMapping("/visualisation")
    public String visualisationWithoutId(Model model){
        List<ProjectEntity> projectList = projectRepository.findProjectForUser(UserHelper.getUserName());
        model.addAttribute("projectList",projectList);
        return "visualisation";
    }

    @GetMapping("/visualisation/pid={pid}")
    public String visualisation(Model model, @RequestParam(value = "pid") Optional<String> pid){
        List<ProjectEntity> projectList = projectRepository.findProjectForUser(UserHelper.getUserName());
        model.addAttribute("projectList",projectList);
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
