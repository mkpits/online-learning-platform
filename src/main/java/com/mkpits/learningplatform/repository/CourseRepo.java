package com.mkpits.learningplatform.repository;

import com.mkpits.learningplatform.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Courses, Long> {

}
