package com.mkpits.learningplatform.controller.test;

import com.mkpits.learningplatform.model.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetTestController {
    @GetMapping("/getTagPage")
    public String getTagPage(Model model){
        Test test = new Test();
        model.addAttribute("tag",test);
        return "test/tag_page";
    }
}
