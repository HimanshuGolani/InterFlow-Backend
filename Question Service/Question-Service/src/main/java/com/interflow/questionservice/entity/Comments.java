package com.interflow.questionservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Entity(name = "comments")
@Getter
@Setter
public class Comments {
    @Id
    private UUID id;
//    commented by
    private String name;
//    likes and is likes
    private long likes;
    private long dislikes;

    @CreatedDate
    private LocalDateTime createdAt;

}
