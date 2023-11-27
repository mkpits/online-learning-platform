package com.mkpits.learningplatform.controller.user.student;

import com.mkpits.learningplatform.model.User;
import com.mkpits.learningplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class StudentDashboardController {

    @Autowired
    private UserService userService;

    @RequestMapping("/student/index")
    public String studentLogin(Model model, Principal principal) {

        String userName = principal.getName();

        User user = userService.getUserByUserName(userName);
        System.out.println(user);

        model.addAttribute("user", user);
        model.addAttribute("title", "Student - Dashboard");
        System.out.println(userName);

        return "student/dashboard";
    }
}
