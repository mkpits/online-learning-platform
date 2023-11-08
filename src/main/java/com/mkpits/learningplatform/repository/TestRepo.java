package com.mkpits.learningplatform.repository;

import com.mkpits.learningplatform.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test,Long> {
}
