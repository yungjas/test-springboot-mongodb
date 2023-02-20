package com.testspring.demo.Repository;

import com.testspring.demo.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionOptionRepository extends MongoRepository<QuestionOption, String>{
    
}
