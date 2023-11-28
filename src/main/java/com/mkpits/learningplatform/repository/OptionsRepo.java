package com.mkpits.learningplatform.repository;

import com.mkpits.learningplatform.model.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface OptionsRepo extends JpaRepository<Options,Long> {

    @Query("select o from Options o inner join Question q on o.question_id = q.question_id where o.tag = :tag")
    List<Options> findQueAndOptionByTag(@Param("tag") String tag);

    @Query("select o from Options o inner join Question q on o.question_id = q.question_id where o.question_id = :questionId")
    List<Options> findOptionByQuestionId(@Param("questionId") Long questionId);

}
