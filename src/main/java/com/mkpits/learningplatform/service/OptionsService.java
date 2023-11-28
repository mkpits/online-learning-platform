package com.mkpits.learningplatform.service;

import com.mkpits.learningplatform.dto.response.QuestionResponse;
import com.mkpits.learningplatform.model.Options;

import java.util.List;

public interface OptionsService {
    List<Options> getQueAndOptByTag(String tag);
}
