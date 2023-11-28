package com.mkpits.learningplatform.service.impl;

import com.mkpits.learningplatform.dto.response.OptionsResponse;
import com.mkpits.learningplatform.dto.response.QuestionResponse;
import com.mkpits.learningplatform.model.Options;
import com.mkpits.learningplatform.model.Question;
import com.mkpits.learningplatform.repository.OptionsRepo;
import com.mkpits.learningplatform.repository.QuestionRepo;
import com.mkpits.learningplatform.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepo questionRepo;
    @Autowired
    OptionsRepo optionsRepo;

    @Override
    public List<QuestionResponse> getQuestionByTag(String tag) {
        List<Question> questionList = questionRepo.findByTag(tag);
        List<QuestionResponse> questionResponseList = convertQuestionToQuestionResponse(questionList);
        return questionResponseList;
    }

    private List<QuestionResponse> convertQuestionToQuestionResponse(List<Question> questionList) {
        List<QuestionResponse> questionResponseList = new ArrayList<>();
        questionList.stream().forEach(question -> {
            QuestionResponse questionResponse = QuestionResponse.builder()
                    .question_id(question.getQuestion_id())
                    .tag(question.getTag())
                    .options(new ArrayList<>())
                    .questions(question.getQuestions()).build();
            List<Options> optionsList = optionsRepo.findOptionByQuestionId(question.getQuestion_id());
            if(optionsList.size() > 0) {
                optionsList.stream().forEach(options -> {
                    OptionsResponse optionsResponse = OptionsResponse.builder()
                            .option_id(options.getOption_id())
                            .que_option(options.getQue_option())
                            .build();
                    questionResponse.getOptions().add(optionsResponse);
                });
            } else {
                questionResponse.setOptions(new ArrayList<>());
            }
            questionResponseList.add(questionResponse);
        });
        return questionResponseList;
    }


}
