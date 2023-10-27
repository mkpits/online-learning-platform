package com.mkpits.learningplatform.service.impl;

import com.mkpits.learningplatform.model.Courses;
import com.mkpits.learningplatform.model.UserCourseEntity;
import com.mkpits.learningplatform.repository.CourseRepo;
import com.mkpits.learningplatform.repository.UserCourseRepo;
import com.mkpits.learningplatform.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCourseServiceImpl implements UserCourseService {
    @Autowired
    private UserCourseRepo userCourseRepo;
    @Autowired
    private CourseRepo courseRepo;
    @Override
    public UserCourseEntity addUserCourse(UserCourseEntity userCourseEntity) {
        return userCourseRepo.save(userCourseEntity);
    }

    @Override
    public List<Courses> SeeAllCourses() {
        return courseRepo.findAll();
    }


}
