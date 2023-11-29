package com.mkpits.learningplatform.controller.user.admin;

import com.mkpits.learningplatform.model.User;
import com.mkpits.learningplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class AdminDashboardController {

    @Autowired
    private UserService userService;

    @RequestMapping("/admin/index")
    public String adminLogin(Model model, Principal principal) {

        String userName = principal.getName();

        User user = userService.getUserByUserName(userName);

        model.addAttribute("user", user);
        model.addAttribute("title", "Admin - Dashboard");
        return "/admin/admin-dashboard";
    }
}
