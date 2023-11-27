//package com.mkpits.learningplatform.controller.user.normal;
//
//import com.mkpits.learningplatform.helper.Message;
//import com.mkpits.learningplatform.model.User;
//import com.mkpits.learningplatform.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class PostUserLoginController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/login")
//    public String userLogin(@ModelAttribute("user") User user,
//                            Model model,
//                            HttpSession session) {
//
//        String enteredUsername = user.getEmail();
//        String enteredPassword = user.getPassword();
//
//        String returnValue = "";
//
//        User getSearchedUserFromDB = userService.getUserByUsernameAndPassword(enteredUsername, enteredPassword);
//
//        try {
//            // null check
//            if (getSearchedUserFromDB == null) {
//                System.out.println("Something went wrong!!!!!");
//                throw new Exception("Invalid Username or Password");
//            }
//
//            // Admin role login
//            if (getSearchedUserFromDB.getRoleValue().equals("ADMIN")) {
//                System.out.println("Admin Login Successfully of " + getSearchedUserFromDB.getDisplayName());
//                session.setAttribute("displayName", getSearchedUserFromDB.getDisplayName());
//                session.setAttribute("loginMessage", new Message("Login Successful", "alert-success"));
//
//                returnValue = "redirect:/admin/dashboard";
//            }
//
//            // Student role login
//            if (getSearchedUserFromDB.getRoleValue().equals("STUDENT")) {
//                System.out.println("Student Login Successfully of " + getSearchedUserFromDB.getDisplayName());
//                session.setAttribute("displayName", getSearchedUserFromDB.getDisplayName());
//                session.setAttribute("loginMessage", new Message("Login Successful", "alert-success"));
//
//                returnValue = "redirect:/dashboard";
//            }
//
//        } catch (Exception exception) {
//            System.out.println("Invalid Username");
//            session.setAttribute("invalidCredentials", new Message("Invalid Credentials", "alert-danger"));
//            returnValue = "login";
//        }
//
//        return returnValue;
//    }
//}
