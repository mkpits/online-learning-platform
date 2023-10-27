package com.mkpits.learningplatform.controller;

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
    @GetMapping("/enrollCourse")
    public String enrollCourse(Model model){
        UserCourseEntity userCourseEntity=new UserCourseEntity();
        model.addAttribute("adduserCourse",userCourseEntity);
        return "courseEnrollment";
    }


    @RequestMapping(value = "/saveuserCourse", method = RequestMethod.POST)
    public String userCourse(@ModelAttribute("adduserCourse") UserCourseEntity userCourseEntity){
        userCourseService.addUserCourse(userCourseEntity);
        System.out.println(userCourseEntity);
        return "home";
    }

    @GetMapping("/seecourse")
    public String getAllCourse(Model model){
        model.addAttribute("seecourse",courseService.getAllCourses());
        return "userDashboard";
    }

}
