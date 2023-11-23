package com.mkpits.learningplatform.controller.user.normal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentDashboardController {

    @GetMapping("/dashboard")
    public String studentLogin() {

        return "/normal-user/dashboard";
    }
}
