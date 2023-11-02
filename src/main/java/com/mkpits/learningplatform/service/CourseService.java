package com.mkpits.learningplatform.service;

import com.mkpits.learningplatform.model.Courses;
import com.mkpits.learningplatform.model.UserCourseEntity;

import java.util.List;

public interface CourseService {
    List<Courses> getAllCourses();

    Courses saveCourses(Courses courses);
    Courses getCoursebyId(Long id);

    Courses updateCourses(Courses courses);

     void deleteCourseById(Long id);

     Courses updateCourse(Courses courses);

}
