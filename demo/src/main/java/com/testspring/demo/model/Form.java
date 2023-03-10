package com.testspring.demo.model;

import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.testspring.demo.Cascade.CascadeSave;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;

@Document(collection = "form")
public class Form {
    
    // this id is auto generated by mongo
    // @Id
    // private ObjectId _id;

    @Id
    private String formId;

    private String formNo;

    private String formName;

    private Date revisionDate = new Date();

    private Date submittedDate;

    private Date approvalDate;
    
    // capture various form information such as name of company, scope of work etc
    // dynamic
    private Map<String, Object> formInfo;

    //@DBRef
    //@CascadeSave
    private ArrayList<Question> questions;

    // @DBRef
    // private ArrayList<QuestionOption> qnOptions;

    // @OneToMany(mappedBy = "form")
    // private Set<Question> questions;

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    // public ObjectId get_id() {
    //     return _id;
    // }

    // public void set_id(ObjectId _id) {
    //     this._id = _id;
    // }

    public String getFormNo() {
        return formNo;
    }

    public void setFormNo(String formNo) {
        this.formNo = formNo;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public Date getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Date revisionDate) {
        this.revisionDate = revisionDate;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Map<String, Object> getFormInfo() {
        return formInfo;
    }

    public void setFormInfo(Map<String, Object> formInfo) {
        this.formInfo = formInfo;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void setQuestion(Question question){
        if(this.questions == null){
            this.questions = new ArrayList<>();
        }
        this.questions.add(question);
    }

    // public ArrayList<QuestionOption> getQnOptions() {
    //     return qnOptions;
    // }

    // public void setQnOptions(ArrayList<QuestionOption> qnOptions) {
    //     this.qnOptions = qnOptions;
    // }

    // public Set<Question> getQuestions() {
    //     return questions;
    // }
}
