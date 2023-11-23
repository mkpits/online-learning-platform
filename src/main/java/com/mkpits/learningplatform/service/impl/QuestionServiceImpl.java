package com.mkpits.learningplatform.service.impl;

import com.mkpits.learningplatform.model.Question;
import com.mkpits.learningplatform.repository.QuestionRepo;
import com.mkpits.learningplatform.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepo questionRepo;
    @Override
    public List<Question> getQuestionByTag(String tag) {
        List<Question> questionList = questionRepo.findByTag(tag);
        return questionList;
    }
}
