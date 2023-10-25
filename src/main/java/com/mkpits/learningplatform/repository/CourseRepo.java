package com.mkpits.learningplatform.repository;

import com.mkpits.learningplatform.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepo extends JpaRepository<Courses,Long> {

}
