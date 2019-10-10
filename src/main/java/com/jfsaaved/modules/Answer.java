package com.jfsaaved.modules;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    @ManyToOne
    private Question question;
    @Length(max=1000)
    private String questionCase;
    @Length(max=1000)
    private String questionSolution;

    public Answer() {

    }

    public Answer(Question question, String questionCase, String questionSolution) {
        this.question = question;
        this.questionCase = questionCase;
        this.questionSolution = questionSolution;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getQuestionCase() {
        return questionCase;
    }

    public void setQuestionCase(String questionCase) {
        this.questionCase = questionCase;
    }

    public String getQuestionSolution() {
        return questionSolution;
    }

    public void setQuestionSolution(String questionSolution) {
        this.questionSolution = questionSolution;
    }

}
