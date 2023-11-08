package com.mkpits.learningplatform.controller.user.normal;

import com.mkpits.learningplatform.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class GetResetPasswordController {

    @GetMapping("/reset-password")
    public String resetPassword(Model model, HttpSession session) {
        model.addAttribute("title", "Forgot Password - Reset Password");
        User user = (User) session.getAttribute("found-user");
        session.setAttribute("user", user);
        model.addAttribute("user", user);

        return "reset-password";
    }
}
