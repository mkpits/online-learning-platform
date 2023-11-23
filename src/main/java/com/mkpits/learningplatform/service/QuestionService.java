package com.mkpits.learningplatform.service;

import com.mkpits.learningplatform.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionByTag(String tag);
}
