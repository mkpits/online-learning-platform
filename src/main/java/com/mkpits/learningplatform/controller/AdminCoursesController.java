package com.mkpits.learningplatform.controller;

import com.mkpits.learningplatform.model.Courses;
import com.mkpits.learningplatform.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminCoursesController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/addCourse")
    public String addCourse(Model model){
        Courses courses=new Courses();
        model.addAttribute("addcourse",courses);
        return "addCourse";
    }

    @RequestMapping(value = "/savecourse", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("addcourse") Courses courses){
        courseService.saveCourses(courses);
        System.out.println(courses);
        return "redirect:/savecourse";
    }
    @GetMapping("/showcourse")
    public String getAllCourse(Model model){
        model.addAttribute("addcourse",courseService.getAllCourses());
        return "AdminDashBoard";
    }

}
