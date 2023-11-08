package com.mkpits.learningplatform.controller.user.normal;

import com.mkpits.learningplatform.helper.Message;
import com.mkpits.learningplatform.model.User;
import com.mkpits.learningplatform.repository.UserRepo;
import com.mkpits.learningplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PostUpdatePasswordController {

    @Autowired
    private UserService userService;

    @PostMapping("/reset-password")
    public String updateUserPassword(@ModelAttribute("user") User user,
                                     HttpSession session) {

        User registerdUser = (User) session.getAttribute("user");

        String username = registerdUser.getEmail();
        String updatedPassword = user.getPassword();

        System.out.println(username);
        System.out.println(updatedPassword);

        int updatedPasswordUser = userService.resetUserPassword(username, updatedPassword);

        System.out.println(updatedPasswordUser);

        try {

            if (updatedPasswordUser < 1) {
                System.out.println("Something went wrong!!!");
                throw new Exception("Password is not updated in Database");
            }

            session.setAttribute("loginMessage", new Message("Password Reset Successful", "alert-success"));

        } catch (Exception e) {

            System.out.println("Something went wrong!!!");
            session.setAttribute("loginMessage", new Message("Something Went Wrong", "alert-danger"));
        }

        return "reset-password";
    }
}
