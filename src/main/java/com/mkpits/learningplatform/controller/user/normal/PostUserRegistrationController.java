package com.mkpits.learningplatform.controller.user.normal;

import com.mkpits.learningplatform.helper.Message;
import com.mkpits.learningplatform.model.User;
import com.mkpits.learningplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class PostUserRegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerNewUser(@Valid @ModelAttribute("user") User user,
                                  BindingResult bindingResult,
                                  Model model,
                                  @RequestParam(value = "agreement",
                                          defaultValue = "false") boolean agreement,
                                  HttpSession session) {

        try {
            // Agreement check
            if (!agreement) {
                System.out.println("You have not agreed the terms and conditions");
                throw new Exception("You have not agreed the terms and conditions");
            }

            // Validation Check
            if (bindingResult.hasErrors()) {
                model.addAttribute("user", user);
                return "user-signup";
            }

            User saveUser = userService.registerNewUser(user);

            model.addAttribute("user", new User());
            session.setAttribute("message", new Message("Successfully Registered!!! ", "alert-success"));

            return "user-signup";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user", user);
            session.setAttribute("message", new Message("Something went wrong!!! " + e.getMessage(), "alert-danger"));

            return "user-signup";
        }

    }
}
