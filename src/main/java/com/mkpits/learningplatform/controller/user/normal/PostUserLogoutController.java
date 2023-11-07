package com.mkpits.learningplatform.controller.user.normal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostUserLogoutController {

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {

        request.getSession().invalidate();
        System.out.println("Logout Successfully");
        return "redirect:/login";
    }
}
