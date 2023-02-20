package com.testspring.demo.Service;

import com.testspring.demo.model.QuestionOption;
// import org.springframework.beans.factory.annotation.Autowired;
import com.testspring.demo.Repository.QuestionOptionRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionOptionService {
    private final QuestionOptionRepository questionOptionRepository;

    public QuestionOptionService(QuestionOptionRepository questionOptionRepository){
        this.questionOptionRepository = questionOptionRepository;
    }

    public List<QuestionOption> getAllQuestionOptions(){
        return questionOptionRepository.findAll();
    }

    public Optional<QuestionOption> getQuestionOptionById(String qnOptionId){
        Optional<QuestionOption> qnOption = questionOptionRepository.findById(qnOptionId);
        return qnOption;
    }

    public QuestionOption createQuestionOption(QuestionOption qnOption){
        return questionOptionRepository.save(qnOption);
    }
}
