package com.paavan;

import jakarta.persistence.*;

@Entity(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;                                    // Primary Key

    private String question;                                   // Question

    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
    private Answer answer;                                     // Answer Object, OneToOne Mapped

    protected Question(){}   // Default Constructor

    Question(String question) {
        this.question = question;
    }

    // Getters and Setters
    String getQuestion() {
        return this.question;
    }

    Answer getAnswer() {
        return this.answer;
    }

    void setQuestion(String question) {
        this.question = question;
    }

    void setAnswer(Answer answer) {
        this.answer = answer;
        answer.setQuestion(this); // Setting the answer for this instance
    }
}
