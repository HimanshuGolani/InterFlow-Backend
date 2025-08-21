package com.interflow.questionservice.repository;

import com.interflow.questionservice.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentsRepository extends JpaRepository<Comments, UUID> {
}
