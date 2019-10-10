package com.jfsaaved.controller;

import com.jfsaaved.modules.Question;
import com.jfsaaved.service.AnswerService;
import com.jfsaaved.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    QuestionService questionService;
    @Autowired
    AnswerService answerService;

    @RequestMapping("/")
    public String day1Questions(Model model){
        model.addAttribute("questions", questionService.list());
        model.addAttribute("answers", answerService.list());
        return "question/list";
    }

}
