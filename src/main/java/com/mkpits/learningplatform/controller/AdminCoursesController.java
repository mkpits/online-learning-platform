package com.mkpits.learningplatform.controller;

import com.mkpits.learningplatform.model.Courses;
import com.mkpits.learningplatform.model.UserCourseEntity;
import com.mkpits.learningplatform.service.CourseService;
import com.mkpits.learningplatform.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminCoursesController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private UserCourseService userCourseService;
    @GetMapping("/index")
    public String index(){
        return "AdminDashBoard";
    }
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
        return "AdminDashBoard";
    }
    @GetMapping("/showcourse")
    public String getAllCourse(Model model){
        model.addAttribute("addcourse",courseService.getAllCourses());
        return "AdminDashBoard";
    }

    @GetMapping("/deletebycourseid/{id}")
    public String deleteCourse(@PathVariable Long id){
        courseService.deleteCourseById(id);
        return "redirect:/AdminDashBoard";
    }



}
