package com.example.quiz;


import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String questionText;

    @Column(nullable = false)
    private String option_a;

    @Column(nullable = false)
    private String option_b;

    @Column(nullable = false)
    private String option_c;

    @Column(nullable = false)
    private String option_d;

    @Column(nullable = false)
    private String correctAnswer;

    public Questions(String questionText, String optionA, String optionB, String optionC, String optionD, String correctAnswer) {
        this.questionText = questionText;
        this.option_a = optionA;
        this.option_b = optionB;
        this.option_c = optionC;
        this.option_d = optionD;
        this.correctAnswer = correctAnswer;
    }

    public Questions() {
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getOptionA() {
        return option_a;
    }

    public void setOptionA(String optionA) {
        this.option_a = optionA;
    }

    public String getOptionB() {
        return option_b;
    }

    public void setOptionB(String optionB) {
        this.option_b = optionB;
    }

    public String getOptionC() {
        return option_c;
    }

    public void setOptionC(String optionC) {
        this.option_c = optionC;
    }

    public String getOptionD() {
        return option_d;
    }

    public void setOptionD(String optionD) {
        this.option_d = optionD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}