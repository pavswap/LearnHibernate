package com.paavan;

import jakarta.persistence.*;

@Entity(name  = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answerId;                                    // Primary Key

    private String answer;                                   // question

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;                             // Question object, joined using question_id column

    protected Answer() {} // Default Constructor

    Answer(String answer) {
        this.answer = answer;
    }

    String getAnswer() {
        return this.answer;
    }

    Question getQuestion() {
        return this.question;
    }

    void setAnswer(String answer) {
        this.answer = answer;
    }

    void setQuestion(Question question) {
        this.question = question;
        question.setAnswer(this);
    }
}
