package com.mkpits.learningplatform.controller.user.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminDashboardController {

    @GetMapping("/admin/dashboard")
    public String adminLogin(){

        return "/admin/admin-dashboard";
    }
}
