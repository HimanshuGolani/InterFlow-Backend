package com.interflow.questionservice.repository;

import com.interflow.questionservice.dto.response.SmallQuestion;
import com.interflow.questionservice.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionsRepository extends JpaRepository<Question, UUID> {

    @Query("SELECT new com.interflow.questionservice.dto.response.SmallQuestion(" +
            "q.id, q.title, q.question, q.upVotes, q.downVotes, " +
            "CAST(q.createdAt AS string), q.viewedByCount, q.tags) " +
            "FROM Questions q WHERE q.userId = :userId")
    List<SmallQuestion> getQuestionsWIthUserId(UUID userId);


}

