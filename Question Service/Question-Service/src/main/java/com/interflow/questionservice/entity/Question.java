package com.interflow.questionservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Entity(name = "Questions")
@Getter
@Setter
public class Question {

    @Id
    private UUID id;

    private String title;

    private UUID userId;

    private List<String> tags = new ArrayList<>();

    private String question;

    private long upVotes;

    private List<UUID> likedBy = new ArrayList<>();
    private List<UUID> dislikedBy = new ArrayList<>();

    private long downVotes;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("createdAt DESC, likes DESC")
    private List<Comments> comments = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdAt;

    private long viewedByCount;

    private Set<UUID> viewedBy = new HashSet<>();

}
