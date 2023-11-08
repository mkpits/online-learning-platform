package com.mkpits.learningplatform.controller.user.normal;

import com.mkpits.learningplatform.helper.Message;
import com.mkpits.learningplatform.model.User;
import com.mkpits.learningplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PostForgotPasswordController {

    @Autowired
    private UserService userService;

    @PostMapping("/forgot-password")
    public String postForgotPasswordPage(Model model) {

        model.addAttribute("title", "Forgot Password - Search User");
        return "forgot-password";
    }

    @PostMapping("/search-user")
    public String postSearchUser(@ModelAttribute("user") User user,
                                 HttpSession session) {

        String searchingUsername = user.getEmail();

        User userFromDB = userService.getUserByUserName(searchingUsername);

        try {
            // null check
            if (userFromDB == null) {
                System.out.println("Invalid username or user not registered !!!!!");
                throw new Exception("Invalid username or user not registered");
            }

            session.setAttribute("found-user", userFromDB);

            return "redirect:/reset-password";

        } catch (Exception exception) {
            System.out.println("Invalid username or user not registered !!!!!");
            session.setAttribute("userNotFound", new Message("Invalid Username", "alert-danger"));

            return "forgot-password";
        }

    }
}
