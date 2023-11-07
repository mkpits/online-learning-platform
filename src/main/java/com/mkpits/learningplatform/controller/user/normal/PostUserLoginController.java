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
public class PostUserLoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String userLogin(@ModelAttribute("user") User user,
                            Model model,
                            HttpSession session) {

        String enteredUsername = user.getEmail();
        String enteredPassword = user.getPassword();

        User getUserFromDB = userService.getUserByUserName(enteredUsername);

        String getUsernameFromDB = getUserFromDB.getEmail();
        String getPasswordFromDB = getUserFromDB.getPassword();

        String returnValue = "";

        if (enteredUsername.equals(getUsernameFromDB) && enteredPassword.equals(getPasswordFromDB)) {

            // ADMIN role login
            if (getUserFromDB.getRoleValue().equals("ADMIN")) {
                System.out.println("Admin Login Successfully of " + getUserFromDB.getDisplayName());
                session.setAttribute("displayName", getUserFromDB.getDisplayName());
//                session.setAttribute("loginMessage", new Message("Login Successful", "alert-success"));

                returnValue = "redirect:/admin/dashboard";
            }

            // STUDENT role login
            if (getUserFromDB.getRoleValue().equals("STUDENT")) {
                System.out.println("Student Login Successfully of " + getUserFromDB.getDisplayName());
                session.setAttribute("displayName", getUserFromDB.getDisplayName());
//                session.setAttribute("LoginMessage", new Message("Login Successful", "alert-success"));

                returnValue = "redirect:/dashboard";
            }

        } else {
            System.out.println("Something went wrong");
            model.addAttribute("user", user);
//            session.setAttribute("errorMsg", new Message("Something went wrong!!! ", "alert-danger"));

            returnValue = "user-login";
        }

        return returnValue;
    }
}
