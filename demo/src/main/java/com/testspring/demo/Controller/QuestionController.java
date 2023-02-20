package com.testspring.demo.Controller;

// import org.springframework.beans.factory.annotation.Autowired;
import com.testspring.demo.Service.QuestionService;
import com.testspring.demo.model.Question;
import com.testspring.demo.model.QuestionOption;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/vms/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("{qnId}")
    public Optional<Question> getQuestionById(@PathVariable String qnId){
        return questionService.getQuestionById(qnId);
    }

    @PostMapping("/create")
    public Question createQuestion(@RequestBody Question qn){
        return questionService.createQuestion(qn);
    }

    @PostMapping("createoption/{qnId}")
    public Question createOptionsForQuestion(@PathVariable String qnId, @RequestBody ArrayList<QuestionOption> qnOptions){
        return questionService.createOptionsForQuestion(qnId, qnOptions);
    }

    @PostMapping("addoption/{qnId}/{qnOptionId}")
    public Question addOptionsToQuestion(@PathVariable String qnId, @PathVariable String qnOptionId){
        return questionService.addOptionsToQuestion(qnId, qnOptionId);
    }
}
