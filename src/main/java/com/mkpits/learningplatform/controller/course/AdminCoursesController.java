package com.mkpits.learningplatform.controller.course;

import com.mkpits.learningplatform.model.Courses;
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

    @GetMapping("/admindashboard")
    public String index() {
        return "admin-dashboard";
    }

    @GetMapping("/addCourse")
    public String addCourse(Model model) {
        Courses courses = new Courses();
        model.addAttribute("addcourse", courses);
        return "add-course";
    }

    @RequestMapping(value = "/savecourse", method = RequestMethod.POST)
    public String saveCourse(@ModelAttribute("addcourse") Courses courses) {
        courseService.saveCourses(courses);
        System.out.println(courses);
        return "admin-dashboard";
    }

    @GetMapping("/showcourse")
    public String getAllCourse(Model model) {
        model.addAttribute("addcourse", courseService.getAllCourses());
        return "admin-dashboard";
    }

    @GetMapping("/deleteByCourseId/{id}")
    public String deleteCourse(@ModelAttribute @PathVariable Long id) {
        courseService.deleteCourseById(id);

        return "redirect:/showcourse";
    }
         @GetMapping("/course/edit/{id}")
         public String editCourse(@PathVariable Long id,Model model){
        model.addAttribute("course",courseService.getCoursebyId(id));
        return "edit_course";
    }

            @PostMapping("/courses/{id}")
            public String updateCourse( @PathVariable Long id, @ModelAttribute("course") Courses courses, Model model){
        // getting course from database by id
                Courses existingCourse = courseService.getCoursebyId(id);
                existingCourse.setCourseId(id);
                existingCourse.setCourseName(courses.getCourseName());
                existingCourse.setUpdatedBy(courses.getUpdatedBy());
                existingCourse.setUpdatedAt((courses.getUpdatedAt()));
                existingCourse.setDescription(courses.getDescription());
                existingCourse.setCreatedBy(courses.getCreatedBy());
                existingCourse.setCreatedAt(courses.getCreatedAt());
                courseService.updateCourses(existingCourse);
                return "redirect:/showcourse";
            }


}
