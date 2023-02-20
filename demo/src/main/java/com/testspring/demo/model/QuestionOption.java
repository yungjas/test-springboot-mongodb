package com.testspring.demo.model;

import java.util.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "questionoption")
public class QuestionOption {
    @Id
    private String qnOptionId;

    // allow options for questions to be dynamic since we cant really predict
    private Map<String, Object> options;

    public String getQnOptionId() {
        return qnOptionId;
    }

    public void setQnOptionId(String qnOptionId) {
        this.qnOptionId = qnOptionId;
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public void setOptions(Map<String, Object> options) {
        this.options = options;
    }
}
