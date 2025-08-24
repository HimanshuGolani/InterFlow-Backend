package com.interflow.questionservice.dto.response;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class SmallQuestion {
    private UUID id;
    private String title;
    private String question;
    private long upVotes;
    private long downVotes;
    private String createdAt;
    private long viewedBy;
    private List<String> tags;

    private String userName;
    private String imageUrl;

    public SmallQuestion(UUID id, String title, String question, long upVotes, long downVotes,
                         String createdAt, long viewedBy, List<String> tags) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.upVotes = upVotes;
        this.downVotes = downVotes;
        this.createdAt = createdAt;
        this.viewedBy = viewedBy;
        this.tags = tags;
    }
}
