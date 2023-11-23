package com.mkpits.learningplatform.controller.test;

import com.mkpits.learningplatform.model.Question;
import com.mkpits.learningplatform.model.Test;
import com.mkpits.learningplatform.service.QuestionService;
import com.mkpits.learningplatform.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PostTestController {
    @Autowired
    TestService testService;
    @Autowired
    QuestionService questionService;
    @PostMapping("/getSelectedTagPage")
    public String getSelectedTagPage(@ModelAttribute("topic") Test test, @RequestParam(name = "tag") String tag, Model model) {
        testService.getChoiceTagPage(test);

        //requesting core java question page
        if (tag.equals("CORE_JAVA")) {
            // getting list of questions on core java page
            List<Question> questionsList = questionService.getQuestionByTag(tag);
            model.addAttribute("questions",questionsList);
            return "test/core_java";
        }
        //requesting Mysql question page
        else if (tag.equals("MY_SQL")) {
            // getting list of questions on Mysql page
            List<Question> questionsList = questionService.getQuestionByTag(tag);
            model.addAttribute("questions",questionsList);
            return "test/mysql";
        }
        //requesting C question page
        else if (tag.equals("C")) {
            // getting list of questions on C language page
            List<Question> questionsList = questionService.getQuestionByTag(tag);
            model.addAttribute("questions",questionsList);
            return "test/c";
        }
        //requesting C++ question page
        else if (tag.equals("C++")) {
            // getting list of questions on cpp page
            List<Question> questionsList = questionService.getQuestionByTag(tag);
            model.addAttribute("questions",questionsList);
            return "test/cpp";
        }
        //requesting Html question page
        else if (tag.equals("HTML")) {
            // getting list of questions on html page
            List<Question> questionsList = questionService.getQuestionByTag(tag);
            model.addAttribute("questions",questionsList);
            return "test/html";
        }
        //requesting Css question page
        else if (tag.equals("CSS")) {
            // getting list of questions on css page
            List<Question> questionsList = questionService.getQuestionByTag(tag);
            model.addAttribute("questions",questionsList);
            return "test/css";
        }
        //requesting Javascript question page
        else {
            // getting list of questions on javascript page
            List<Question> questionsList = questionService.getQuestionByTag(tag);
            model.addAttribute("questions",questionsList);
            return "test/javascript";
        }

    }
}
