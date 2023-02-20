package com.testspring.demo.Service;

import com.testspring.demo.model.*;
// import org.springframework.beans.factory.annotation.Autowired;
import com.testspring.demo.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
	private QuestionOptionService qnOptionService;
    
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(String qnId){
        Optional<Question> qn = questionRepository.findById(qnId);
        return qn;
    }

    public Question createQuestion(Question qn){
        questionRepository.save(qn);
        return qn;
    }

    // public Question createQuestionForForm(Question qn, String formId){
    //     Form form = 
    // }

    public Question createOptionsForQuestion(String qnId, ArrayList<QuestionOption> qnOptions){
        Question qn = questionRepository.findById(qnId).get();
        if(qn != null){
            if(qn.getQnOptions() != null){
                qn.getQnOptions().addAll(qnOptions);
            }
            else{
                qn.setQnOptions(qnOptions);
            }
            for(int i = 0; i < qnOptions.size(); i++){
                qnOptionService.createQuestionOption(qnOptions.get(i));
            }
        }
        questionRepository.save(qn);
        return qn;
    }

    public Question addOptionsToQuestion(String qnId, String qnOptionId){
        Question qn = questionRepository.findById(qnId).get();
        QuestionOption qnOption = qnOptionService.getQuestionOptionById(qnOptionId).get();
        if(qn != null && qnOption != null){
            if(qn.getQnOptions() != null){
                qn.getQnOptions().add(qnOption);
            }
            else{
                qn.setQnOption(qnOption);
            }
        }
        questionRepository.save(qn);
        return qn;
    }
}
