package com.mkpits.learningplatform.service.impl;

import com.mkpits.learningplatform.model.Courses;
import com.mkpits.learningplatform.repository.CourseRepo;
import com.mkpits.learningplatform.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceImpl implements CourseService {

    public CourseRepo courseRepo;
    @Override
    public List<Courses> getAllCourses() {
        return null;
    }

    @Override
    public Courses saveCourses(Courses courses) {
        return courseRepo.save(courses);
    }

    @Override
    public Courses getCoursebyId(Long id) {
        return null;
    }

    @Override
    public Courses updateCourses(Courses courses) {
        return null;
    }

    @Override
    public void deleteCourseById(Long id) {

    }
}
