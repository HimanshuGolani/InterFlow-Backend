package com.interflow.questionservice.service.contract;

import com.interflow.questionservice.dto.request.QuestionCreationDto;
import com.interflow.questionservice.dto.response.SmallQuestion;

import java.util.List;

public interface QuestionService {

    void createQuestion(QuestionCreationDto data);
    List<SmallQuestion> searchQuestion();

}
