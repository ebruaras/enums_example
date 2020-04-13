package com.example.demo.controller;

import com.example.demo.question.Question;
import com.example.demo.question.QuestionCategory;
import com.example.demo.question.QuestionCategoryConverter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuestionController {
    @RequestMapping(value = "/{type}",method = RequestMethod.GET)
    public List get(@PathVariable(value = "type")QuestionCategory category){
        return getQuestionByCategory(category);
    }
    private List getQuestionByCategory(QuestionCategory category){
        List questions=new ArrayList();
        Question question=new Question();
        question.setType(category);
        if(category==QuestionCategory.OS){
            question.setQuestion("What is Operating System?");
            question.setAnswer("An operating system (OS) is system software that manages computer hardware, software resources, and provides common services for computer programs.");
        }
        else if(category==QuestionCategory.TS){
            question.setQuestion("What is transistor?");
            question.setAnswer("A transistor is a semiconductor device used to amplify or switch electronic signals and electrical power.");
        }
        questions.add(question);
        return questions;
    }
    @InitBinder
    public void initBinder(final WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(QuestionCategory.class,new QuestionCategoryConverter());
    }
}
