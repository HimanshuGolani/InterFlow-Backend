package com.interflow.questionservice.dto.response;

import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

public class CommentDto {
    private UUID id;
    private String name;
    private long likes;
    private long dislikes;
    private LocalDateTime createdAt;
}
