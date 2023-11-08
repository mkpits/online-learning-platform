package com.mkpits.learningplatform.controller.test;

import com.mkpits.learningplatform.model.Test;
import com.mkpits.learningplatform.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostTestController {
    @Autowired
    TestService testService;
    @PostMapping("/getSelectedTagPage")
    public String getSelectedTagPage(@ModelAttribute("topic") Test test){
            testService.getChoiceTagPage(test);
        return "test/selected_page";
    }
}
