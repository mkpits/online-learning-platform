package com.mkpits.learningplatform.controller.user.student;

import com.mkpits.learningplatform.model.User;
import com.mkpits.learningplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/students")
public class StudentDashboardController {

    @Autowired
    private UserService userService;

    // method for adding common data (common logged-in user)
    // after providing @ModelAttribute annotation it will pass common data to all the handler in class
    @ModelAttribute
    public void getLoggedInUser(Model model, Principal principal) {
        String userName = principal.getName();

        User user = userService.getUserByUserName(userName);

        model.addAttribute("user", user);
    }

    @RequestMapping("/index")
    public String studentLogin(Model model) {

        model.addAttribute("title", "Student - Dashboard");

        return "student/dashboard";
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {

        model.addAttribute("title", "Admin - Profile");
        return "student/student-profile";
    }

    @GetMapping("/settings")
    public String getSettings(Model model) {

        model.addAttribute("title", "Admin - Settings");
        return "student/student-settings";
    }

    @GetMapping("/courses")
    public String getCourses(Model model) {

        model.addAttribute("title", "Admin - Courses");
        return "student/student-courses";
    }
}
