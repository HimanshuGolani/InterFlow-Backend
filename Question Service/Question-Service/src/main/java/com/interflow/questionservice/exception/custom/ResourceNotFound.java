package com.interflow.questionservice.exception.custom;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String message){
        super(message);
    }
}
