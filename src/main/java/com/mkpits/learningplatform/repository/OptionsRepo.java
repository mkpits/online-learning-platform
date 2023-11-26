package com.mkpits.learningplatform.repository;

import com.mkpits.learningplatform.model.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OptionsRepo extends JpaRepository<Options,Long> {

    @Query("select q.questions,o.que_option from Question q inner join Options o on q.question_id=o.que_id where q.tag = :tag")
    List<Options> findQueAndOptionByTag(@Param("tag") String tag);

}
