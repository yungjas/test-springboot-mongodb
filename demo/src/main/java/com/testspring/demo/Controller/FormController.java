package com.testspring.demo.Controller;

// import org.springframework.beans.factory.annotation.Autowired;
import com.testspring.demo.Service.FormService;
import com.testspring.demo.model.*;

import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
@RequestMapping(path="api/vms/forms")
public class FormController {
    private final FormService formService;

    public FormController(FormService formService){
        this.formService = formService;
    }

    @GetMapping
    public List<Form> getAllForms(){
        return formService.getAllForms();
    }
    
    @GetMapping("{formId}")
    public Optional<Form> getFormById(@PathVariable String formId){
        return formService.getFormById(formId);
    }

    @PostMapping("create")
    public Form createForm(@RequestBody Form form){
        return formService.createForm(form);
    }

    @PostMapping("createqn/{formId}")
    public Form createQuestionsForForm(@PathVariable String formId, @RequestBody ArrayList<Question> questions){
        return formService.createQuestionForForm(formId, questions);
    }

    @PostMapping("addqn/{formId}/{qnId}")
    public Form addQuestionToForm(@PathVariable String formId, @PathVariable String qnId){
        return formService.addQuestionToForm(formId, qnId);
    }
}
