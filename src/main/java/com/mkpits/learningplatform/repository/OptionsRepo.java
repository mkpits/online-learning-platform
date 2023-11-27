package com.mkpits.learningplatform.repository;

import com.mkpits.learningplatform.model.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OptionsRepo extends JpaRepository<Options,Long> {

    @Query("select o.que_option from Options o inner join Question q on q.question_id=o.que_id where o.tag = :tag")
    List<Options> findQueAndOptionByTag(@Param("tag") String tag);

}
