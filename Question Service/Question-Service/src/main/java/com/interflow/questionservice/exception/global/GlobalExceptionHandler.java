package com.interflow.questionservice.exception.global;

import com.interflow.questionservice.exception.custom.ResourceCreationException;
import com.interflow.questionservice.exception.custom.ResourceNotFound;
import com.interflow.questionservice.exception.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> IllegalArgumentExceptionHandler(IllegalArgumentException e){
        ErrorResponse response = new ErrorResponse(e.getMessage(),Boolean.FALSE);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundExceptionHandler(ResourceNotFound e){
        ErrorResponse response = new ErrorResponse(e.getMessage(),Boolean.FALSE);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceCreationException.class)
    public ResponseEntity<ErrorResponse> ResourceCreationExceptionHandler(ResourceCreationException e){
        ErrorResponse response = new ErrorResponse(e.getMessage(),Boolean.FALSE);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
