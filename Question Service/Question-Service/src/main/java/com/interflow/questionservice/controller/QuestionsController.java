package com.interflow.questionservice.controller;


import com.interflow.questionservice.dto.request.QuestionCreationDto;
import com.interflow.questionservice.dto.response.SmallQuestion;
import com.interflow.questionservice.service.contract.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionsController {

    private final QuestionService questionService;

//     Get the default questions list for the user it should be based on the previous viewed questions

//     search some question
    @GetMapping
    public ResponseEntity<SmallQuestion> getSmallQuestions(@RequestParam MultiValueMap<String,String> params){
        return null;
    }

//     get the complete question by id include the increment in viewed in count.

//     create question

    @PostMapping
    public ResponseEntity<Void> createQuestion(@RequestBody QuestionCreationDto data){
        questionService.createQuestion(data);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    update question



}
