package com.mkpits.learningplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homepage(Model model){
        model.addAttribute("tittle","Home -Online learning");
        return "/home";
    }

    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("tittle","about -Online learning");
        return "/about";
    }

}
