package com.mkpits.learningplatform.repository;

import com.mkpits.learningplatform.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Long> {
    @Query("select q from Question q where q.tag=:tag")
    List<Question> findByTag(@Param("tag")String tag);
}
