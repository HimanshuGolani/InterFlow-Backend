package com.interflow.userservice.exception;

import com.interflow.userservice.exception.custom.ResourceNotFoundException;
import com.interflow.userservice.exception.messages.ResponseMessages;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. Handle Resource Not Found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, ResponseMessages.RESOURCE_NOT_FOUND.getMessage(), ex.getMessage());
    }

    // 2. Handle the Wrong HTTP Method
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        return buildErrorResponse(HttpStatus.METHOD_NOT_ALLOWED, ResponseMessages.BAD_REQUEST.getMessage(), ex.getMessage());
    }

    // 3. Handle Invalid JSON or Request Body
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleInvalidInput(HttpMessageNotReadableException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ResponseMessages.INVALID_INPUT.getMessage(), "Malformed or missing request body.");
    }

    // 4. Handle IllegalArgument
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgument(IllegalArgumentException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ResponseMessages.INVALID_INPUT.getMessage(), ex.getMessage());
    }

    // 5. Handle Generic Uncaught Exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ResponseMessages.INTERNAL_SERVER_ERROR.getMessage(), ex.getMessage());
    }

    private ResponseEntity<Object> buildErrorResponse(HttpStatus status, String title, String message) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", title);
        body.put("message", message);
        return new ResponseEntity<>(body, new HttpHeaders(), status);
    }
}
