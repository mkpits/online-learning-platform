package com.mkpits.learningplatform.controller.course;

import com.mkpits.learningplatform.model.Courses;
import com.mkpits.learningplatform.model.User;
import com.mkpits.learningplatform.service.CourseService;
import com.mkpits.learningplatform.service.UserCourseService;
import com.mkpits.learningplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class AdminCoursesController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private UserCourseService userCourseService;

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

    @GetMapping("/admindashboard")
    public String index() {
        return "courses/course-dashboard";
    }

    @GetMapping("/addCourse")
    public String addCourse(Model model) {
//        Courses courses = new Courses();
        model.addAttribute("addCourse", new Courses());
        return "admin/add-course";
    }

    @PostMapping("/savecourse")
    public String saveCourseDetails(@ModelAttribute("addCourse") Courses courses,
                                    Model model, HttpSession session) {

        // print successfully contact added message
//        session.setAttribute("message", new Message("Course added Successfully","alert-success"));
        return "redirect:/addCourse";
    }

//    @RequestMapping(value = "/savecourse", method = RequestMethod.POST)
//    public String saveCourse(@ModelAttribute("addcourse") Courses courses) {
//        courseService.saveCourses(courses);
//        System.out.println(courses);
//        return "courses/course-dashboard";
//    }

    @GetMapping("/showcourse")
    public String getAllCourse(Model model) {
        model.addAttribute("addcourse", courseService.getAllCourses());
        return "courses/course-dashboard";
    }

    @GetMapping("/deleteByCourseId/{id}")
    public String deleteCourse(@ModelAttribute @PathVariable Long id) {
        courseService.deleteCourseById(id);

        return "redirect:/showcourse";
    }

    @GetMapping("/course/edit/{id}")
    public String editCourse(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.getCoursebyId(id));
        return "courses/edit_course";
    }

    @PostMapping("/courses/{id}")
    public String updateCourse(@PathVariable Long id, @ModelAttribute("course") Courses courses, Model model) {
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
