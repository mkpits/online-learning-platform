package com.mkpits.learningplatform.service;

import com.mkpits.learningplatform.dto.response.QuestionResponse;
import com.mkpits.learningplatform.model.Options;
import com.mkpits.learningplatform.model.Question;

import java.util.List;

public interface QuestionService {
    List<QuestionResponse> getQuestionByTag(String tag);

}
