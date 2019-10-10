package com.jfsaaved.modules;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private long id;
    private String day;
    private String question;
    @Length(max=1000)
    private String questionDetails;
    @Length(max=1000)
    private String code;
    @OneToMany
    private List<Answer> answers;

    public Question(){

    }

    public Question(String day, String question, String questionDetails) {
        this.day = day;
        this.question = question;
        this.questionDetails = questionDetails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getQuestionDetails() {
        return questionDetails;
    }

    public void setQuestionDetails(String questionDetails) {
        this.questionDetails = questionDetails;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


}
