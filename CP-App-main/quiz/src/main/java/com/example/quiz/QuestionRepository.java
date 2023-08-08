package com.example.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Questions, Long> {

    @Query("SELECT COUNT(q) FROM Questions q")
    long countQuestions();

    @Query("SELECT q.correctAnswer FROM Questions q WHERE q.questionId = ?1")
    String findCorrectAnswerById(Long questionId);


}