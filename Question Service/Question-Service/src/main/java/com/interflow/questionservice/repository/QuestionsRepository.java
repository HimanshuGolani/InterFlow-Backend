package com.interflow.questionservice.repository;

import com.interflow.questionservice.dto.response.SmallQuestion;
import com.interflow.questionservice.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface QuestionsRepository extends JpaRepository<Question, UUID> {

    @Query
    List<SmallQuestion> getQuestions();

}

