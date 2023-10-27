package com.mkpits.learningplatform.service.impl;

import com.mkpits.learningplatform.model.Courses;
import com.mkpits.learningplatform.model.UserCourseEntity;
import com.mkpits.learningplatform.repository.CourseRepo;
import com.mkpits.learningplatform.repository.UserCourseRepo;
import com.mkpits.learningplatform.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceImpl implements CourseService {
    @Autowired
    public CourseRepo courseRepo;
    @Autowired
    public UserCourseRepo userCourseRepo;
    @Override
    public List<Courses> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Courses saveCourses(Courses courses) {
        return courseRepo.save(courses);
    }

    @Override
    public Courses getCoursebyId(Long id) {
        return courseRepo.findById(id).get();
    }

    @Override
    public Courses updateCourses(Courses courses) {
        return courseRepo.save(courses);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepo.deleteById(id);
    }


}
