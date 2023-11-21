package com.mkpits.learningplatform.controller;

import com.mkpits.learningplatform.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    //    Home Handler
    @RequestMapping("/")
    public String homepage(Model model) {
        model.addAttribute("title", "Home - Online Learning");
        return "index";
    }

    //   About Handler
    @RequestMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("title", "About -Online Learning");
        return "about";
    }

    //    Signup Handler
    @RequestMapping("/signup")
    public String signup(Model model, User user) {

        model.addAttribute("title", "Signup - Online Learning");
        model.addAttribute("user", user);

        return "user-signup";
    }

    //     Login Handler
    @RequestMapping("/login")
    public String login(Model model) {

        model.addAttribute("title", "Login - Online Learning");

        return "login";
    }

    //     Courses Handler
    @RequestMapping("/courses")
    public String courses(Model model) {

        model.addAttribute("title", "Courses - Online Learning");

        return "courses/course-dashboard";
    }

}
