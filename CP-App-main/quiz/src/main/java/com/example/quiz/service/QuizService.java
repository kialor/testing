package com.example.quiz.service;

import com.example.quiz.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    private final QuestionRepository questionRepository;

    public QuizService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    public String getCorrectAnswerForQuestion(Long questionId) {
        return questionRepository.findCorrectAnswerById(questionId);
    }
}
