package com.mkpits.learningplatform.controller.user.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminDashboardController {

    @RequestMapping("/admin/index")
    public String adminLogin() {

        return "/admin/admin-dashboard";
    }
}
