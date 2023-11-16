package com.mkpits.learningplatform.controller.test;

import com.mkpits.learningplatform.model.Test;
import com.mkpits.learningplatform.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostTestController {
    @Autowired
    TestService testService;
    @PostMapping("/getSelectedTagPage")
    public String getSelectedTagPage(@ModelAttribute("topic") Test test, @RequestParam(name = "tag")String tag){
            testService.getChoiceTagPage(test);

            //requesting core java question page
            if(tag.equals("CORE_JAVA")){
                return "test/core_java";
            }
            //requesting Mysql question page
            else if(tag.equals("MY_SQL")){
                return "test/mysql";
            }
            //requesting C question page
            else if (tag.equals("C")) {
                return "test/c";
            }
            //requesting C++ question page
            else if (tag.equals("C++")) {
                return "test/cpp";
            }
            //requesting Html question page
            else if (tag.equals("HTML")) {
                return "test/html";
            }
            //requesting Css question page
            else if (tag.equals("CSS")) {
                return "test/css";
            }
            //requesting Javascript question page
            else {
                return "test/javascript";
            }

    }
}
