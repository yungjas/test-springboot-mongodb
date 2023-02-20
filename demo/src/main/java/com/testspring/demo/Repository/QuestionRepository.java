package com.testspring.demo.Repository;

import com.testspring.demo.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
    // may need custom query to get questions by form id
    // @Query("SELECT q from questions")
    // public List<Question> getQuestionsByFormId(String formId);
}
