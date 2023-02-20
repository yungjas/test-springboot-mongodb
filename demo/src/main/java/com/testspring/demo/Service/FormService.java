package com.testspring.demo.Service;

import com.testspring.demo.model.*;
// import org.springframework.beans.factory.annotation.Autowired;
import com.testspring.demo.Repository.FormRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FormService { 
    @Autowired
	private QuestionService questionService;

    private final FormRepository formRepository;
    
    public FormService(FormRepository formRepository){
        this.formRepository = formRepository;
    }

    public List<Form> getAllForms(){
        return formRepository.findAll();
    }

    public Optional<Form> getFormById(String formId){
        // Query query = new Query();
        // query.addCriteria(Criteria.where("formId").is(formId));
        // return mongoTemplate.findOne(query, Form.class);

        Optional<Form> form = formRepository.findById(formId);
        return form;
    }

    public Form createForm(Form form){
        formRepository.save(form);
        return form;
    }

    // after creating form, create the question for the form
    public Form createQuestionForForm(String formId, ArrayList<Question> questions){
        Form form = formRepository.findById(formId).get();
        if(form != null){
            if(form.getQuestions() != null){
                form.getQuestions().addAll(questions);
            }
            else{
                form.setQuestions(questions);
            }
            //this might cause duplicate entries in question collection
            for(int i = 0; i < questions.size(); i++){
                questionService.createQuestion(questions.get(i));
            }
        }
        formRepository.save(form);
        return form;
    }

    // link existing questions to the form
    public Form addQuestionToForm(String formId, String qnId){
        Form form = formRepository.findById(formId).get();
        Question qn = questionService.getQuestionById(qnId).get();
        if(form != null && qn != null){
            if(form.getQuestions() != null){
                // add to existing questions
                form.getQuestions().add(qn);
            }
            else{
                // create a new arraylist and add the question to the list
                form.setQuestion(qn);
            }
        }
        formRepository.save(form);
        return form;
    }
}
