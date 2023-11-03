package com.mkpits.learningplatform.controller.course;

import com.mkpits.learningplatform.model.UserCourseEntity;
import com.mkpits.learningplatform.service.CourseService;
import com.mkpits.learningplatform.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserCourseController {
    @Autowired
    private UserCourseService userCourseService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/seecourse")
    public String getAllCourse(Model model) {
        model.addAttribute("seecourse", courseService.getAllCourses());
        return "userDashboard";
    }

}
