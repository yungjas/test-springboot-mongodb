package com.testspring.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;

@Document(collection = "question")
public class Question {
    @Id
    private String qnId;

    // @Id
    // private ObjectId _id;

    private String qnName;
    
    // @ManyToOne
    // @JoinColumn(name="form_id", nullable = false)
    // private Form form;

    //@DBRef
    //@Field("qnOptions")
    private ArrayList<QuestionOption> qnOptions;

    public String getQnId() {
        return qnId;
    }

    public void setQnId(String qnId) {
        this.qnId = qnId;
    }

    // public ObjectId get_id() {
    //     return _id;
    // }

    // public void set_id(ObjectId _id) {
    //     this._id = _id;
    // }

    public String getQnName() {
        return qnName;
    }

    public void setQnName(String qnName) {
        this.qnName = qnName;
    }

    public ArrayList<QuestionOption> getQnOptions() {
        return qnOptions;
    }

    public void setQnOptions(ArrayList<QuestionOption> qnOptions) {
        this.qnOptions = qnOptions;
    }

    public void setQnOption(QuestionOption qnOption){
        if(this.qnOptions == null){
            this.qnOptions = new ArrayList<>();
        }
        this.qnOptions.add(qnOption);
    }

}
