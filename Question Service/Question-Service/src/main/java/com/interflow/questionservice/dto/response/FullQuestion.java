package com.interflow.questionservice.dto.response;

import com.interflow.questionservice.entity.Comments;

import java.util.List;
import java.util.UUID;

public class FullQuestion {
    private UUID id;
    private String title;
    private String userName;
    private String imageUrl;
    private long upVotes;
    private long downVotes;
    private List<Comments> comments;
    private String createdAt;
    private List<String> tags;
    private String question;

}
