package com.testspring.demo.Controller;

import com.testspring.demo.Service.QuestionOptionService;
import com.testspring.demo.model.QuestionOption;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/vms/questionoption")
public class QuestionOptionController {
    private final QuestionOptionService questionOptionService;

    public QuestionOptionController(QuestionOptionService questionOptionService){
        this.questionOptionService = questionOptionService;
    }

    @GetMapping
    public List<QuestionOption> getAllQuestionOptions(){
        return questionOptionService.getAllQuestionOptions();
    }

    @GetMapping("{qnOptionId}")
    public Optional<QuestionOption> getQuestionOptionById(@PathVariable String qnOptionId){
        return questionOptionService.getQuestionOptionById(qnOptionId);
    }

    @PostMapping("/create")
    public QuestionOption createQuestionOption(@RequestBody QuestionOption qnOption){
        return questionOptionService.createQuestionOption(qnOption);
    }
}
