package com.example.quiz.controller;

import com.example.quiz.QuestionRepository;
import com.example.quiz.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class QuizController {
    private final QuestionRepository questionRepository;

    public QuizController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    private List<Questions> getSpecificQuestions() {
        Long[] specificIds = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L,};
      Long [] moreIds = {12L, 13L, 13L};
        List<Questions> specificQuestions = new ArrayList<>();
        for (Long id : specificIds) {
            Optional<Questions> question = questionRepository.findById(id);
            question.ifPresent(specificQuestions::add);
        }
        return specificQuestions;
    }
    @GetMapping("/quiz")
    public String showQuiz(Model model) {
        List<Questions> specificQuestions = getSpecificQuestions();
        model.addAttribute("questions", specificQuestions);
        return "quiz";
    }

    @GetMapping("/results")
    public String showResults(Model model, @RequestParam int score, @RequestParam String userName, @RequestParam Map<String, String> allParams) {
        List<Questions> specificQuestions = getSpecificQuestions();
        model.addAttribute("questions", specificQuestions);

        // Retrieve the user's selected answers from the query parameters
        Map<Long, String> selectedAnswersMap = new HashMap<>();
        for (Questions question : specificQuestions) {
            String userAnswer = allParams.get("question_" + question.getQuestionId());
            selectedAnswersMap.put(question.getQuestionId(), userAnswer);
        }
        model.addAttribute("selectedAnswers", selectedAnswersMap);

        // Add other attributes like score and userName
        model.addAttribute("score", score);
        model.addAttribute("userName", userName);

        // Fetch the correct answers from the database and store them in a map
        Map<Long, String> correctAnswersMap = new HashMap<>();
        for (Questions question : specificQuestions) {
            correctAnswersMap.put(question.getQuestionId(), question.getCorrectAnswer());
        }
        model.addAttribute("correctAnswers", correctAnswersMap);

        return "results";
    }
    @GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }
    @GetMapping("/category")
    public String showCategoryPage() {
        return "category";
    }
    @PostMapping("/submit")
    public String submitQuiz(@RequestParam Map<String, String> allParams, Model model) {
        String userName = allParams.get("userName"); // Get the user's name from the submitted form data
        int totalQuestions = (int) questionRepository.countQuestions();
        int score = 0;

        // Create a map to store the user's selected answers with question ID as key and user's answer as value
        Map<Long, String> selectedAnswersMap = new HashMap<>();

        List<Questions> questions = questionRepository.findAll();
        for (Questions question : questions) {
            // Get the user's answer for this question from the submitted form data
            String userAnswer = allParams.get("question_" + question.getQuestionId());

            // Compare the user's answer with the correct answer from the database
            if (userAnswer != null && userAnswer.equals(question.getCorrectAnswer())) {
                score++;
            }

            // Add the user's answer to the selectedAnswersMap with question ID as key
            selectedAnswersMap.put(question.getQuestionId(), userAnswer);
        }

        // Add the user's name, selected answers, and score to the model
        model.addAttribute("userName", userName);
        model.addAttribute("selectedAnswers", selectedAnswersMap);
        model.addAttribute("score", score);

        // Fetch the correct answers from the database and store them in a map
        Map<Long, String> correctAnswersMap = new HashMap<>();
        for (Questions question : questions) {
            correctAnswersMap.put(question.getQuestionId(), question.getCorrectAnswer());
        }
        model.addAttribute("correctAnswers", correctAnswersMap);

        // Redirect to the results page with both 'score' and 'userName' query parameters
        StringBuilder redirectUrl = new StringBuilder("redirect:/results?score=");
        redirectUrl.append(score).append("&userName=").append(userName);
        for (Map.Entry<Long, String> entry : selectedAnswersMap.entrySet()) {
            redirectUrl.append("&question_").append(entry.getKey()).append("=").append(entry.getValue());
        }
        return redirectUrl.toString();
    }

    @GetMapping("/pd")
    public String showPD(Model model) {
        Long[] specificIds = {74L, 75L, 76L, 77L, 78L, 79L, 80L, 81L, 82L, 83L}; // Add the specific IDs you want to fetch

        List<Questions> specificQuestions = new ArrayList<>();
        for (Long id : specificIds) {
            Optional<Questions> question = questionRepository.findById(id);
            question.ifPresent(specificQuestions::add);
        }

        model.addAttribute("questions", specificQuestions);
        return "pd";
    }

    @GetMapping("/fs106")
    public String showFS106(Model model) {
        Long[] specificIds = {62L, 63L, 64L,65L,66L, 67L, 68L, 69L, 70L, 71L}; // Add the specific IDs you want to fetch

        List<Questions> specificQuestions = new ArrayList<>();
        for (Long id : specificIds) {
            Optional<Questions> question = questionRepository.findById(id);
            question.ifPresent(specificQuestions::add);
        }

        model.addAttribute("questions", specificQuestions);
        return "fs106";
    }
    @GetMapping("/beginnersjs")
    public String showBeginnersJS(Model model) {
        Long[] specificIds = {12L, 13L, 14L,15L,16L, 17L, 18L, 19L, 20L, 21L}; // Add the specific IDs you want to fetch

        List<Questions> specificQuestions = new ArrayList<>();
        for (Long id : specificIds) {
            Optional<Questions> question = questionRepository.findById(id);
            question.ifPresent(specificQuestions::add);
        }

        model.addAttribute("questions", specificQuestions);
        return "beginnersjs";
    }
    @GetMapping("/advancejs")
    public String advanceJS(Model model) {
        Long[] specificIds = {12L, 13L, 14L,15L,16L, 17L, 18L, 19L, 20L, 21L}; // Add the specific IDs you want to fetch

        List<Questions> specificQuestions = new ArrayList<>();
        for (Long id : specificIds) {
            Optional<Questions> question = questionRepository.findById(id);
            question.ifPresent(specificQuestions::add);
        }

        model.addAttribute("questions", specificQuestions);
        return "advancejs";
    }
    @GetMapping("/oop")
    public String showOop(Model model) {
        Long[] specificIds = {94L, 95L, 96L, 97L,98L, 99L, 100L, 101L, 102L, 103L}; // Add the specific IDs you want to fetch

        List<Questions> specificQuestions = new ArrayList<>();
        for (Long id : specificIds) {
            Optional<Questions> question = questionRepository.findById(id);
            question.ifPresent(specificQuestions::add);
        }

        model.addAttribute("questions", specificQuestions);
        return "oop";
    }
    @GetMapping("/basicJavaInputOutput")
    public String showJavaIO(Model model) {
        Long[] specificIds = {32L, 33L, 34L, 35L,36L, 37L, 38L, 39L, 40L, 41L}; // Add the specific IDs you want to fetch

        List<Questions> specificQuestions = new ArrayList<>();
        for (Long id : specificIds) {
            Optional<Questions> question = questionRepository.findById(id);
            question.ifPresent(specificQuestions::add);
        }

        model.addAttribute("questions", specificQuestions);
        return "basicJavaInputOutput";
    }
    @GetMapping("/sql")
    public String showSql(Model model) {
        Long[] specificIds = {84L, 85L, 86L, 87L, 88L, 89L, 90L, 91L, 92L, 93L}; // Add the specific IDs you want to fetch

        List<Questions> specificQuestions = new ArrayList<>();
        for (Long id : specificIds) {
            Optional<Questions> question = questionRepository.findById(id);
            question.ifPresent(specificQuestions::add);
        }

        model.addAttribute("questions", specificQuestions);
        return "java";
    }
    @GetMapping("/spring")
    public String showSpring(Model model) {
        Long[] specificIds = {42L, 43L, 44L, 45L, 46L, 47L, 48L, 49L, 50L, 51L}; // Add the specific IDs you want to fetch

        List<Questions> specificQuestions = new ArrayList<>();
        for (Long id : specificIds) {
            Optional<Questions> question = questionRepository.findById(id);
            question.ifPresent(specificQuestions::add);
        }

        model.addAttribute("questions", specificQuestions);
        return "spring";
    }
    @GetMapping("/fs105")
    public String showfs105(Model model) {
        Long[] specificIds = {52L, 53L, 54L, 55L, 56L, 57L, 58L, 59L, 60L, 61L}; // Add the specific IDs you want to fetch

        List<Questions> specificQuestions = new ArrayList<>();
        for (Long id : specificIds) {
            Optional<Questions> question = questionRepository.findById(id);
            question.ifPresent(specificQuestions::add);
        }

        model.addAttribute("questions", specificQuestions);
        return "fs105";
    }
}