package com.mkpits.learningplatform.service.impl;

import com.mkpits.learningplatform.model.Test;
import com.mkpits.learningplatform.repository.TestRepo;
import com.mkpits.learningplatform.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    public TestRepo testRepo;

    @Override
    public Test getChoiceTagPage(Test test) {
        return testRepo.save(test);
    }
}
