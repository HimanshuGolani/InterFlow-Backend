package com.interflow.questionservice.service.implementation;

import com.interflow.questionservice.dto.request.QuestionCreationDto;
import com.interflow.questionservice.dto.response.SmallQuestion;
import com.interflow.questionservice.service.contract.QuestionService;
import org.hibernate.boot.model.internal.QuerySecondPass;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Override
    public void createQuestion(QuestionCreationDto data) {
            try {

            }
            catch (Exception e){
                throw new RuntimeException(e);
            }
    }

    @Override
    public List<SmallQuestion> searchQuestion() {
        return List.of();
    }
}
