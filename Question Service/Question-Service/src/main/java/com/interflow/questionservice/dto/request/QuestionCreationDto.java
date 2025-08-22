package com.interflow.questionservice.dto.request;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuestionCreationDto {
    private UUID userId;
    private String title;
    private List<String> tags;
    private String question;
}
