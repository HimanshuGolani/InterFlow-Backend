package com.interflow.questionservice.exception.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private boolean success;
}
