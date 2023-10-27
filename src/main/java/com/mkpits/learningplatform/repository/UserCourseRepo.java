package com.mkpits.learningplatform.repository;

import com.mkpits.learningplatform.model.UserCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCourseRepo extends JpaRepository<UserCourseEntity,Integer> {
}
