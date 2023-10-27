package com.mkpits.learningplatform.service;

import com.mkpits.learningplatform.model.Courses;
import com.mkpits.learningplatform.model.UserCourseEntity;

import java.util.List;

public interface UserCourseService {
    UserCourseEntity addUserCourse(UserCourseEntity userCourseEntity);

    List<Courses> seeAllCourses();


}
