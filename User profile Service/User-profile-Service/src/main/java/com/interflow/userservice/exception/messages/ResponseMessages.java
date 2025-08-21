package com.interflow.userservice.exception.messages;

import lombok.Getter;

@Getter
public enum ResponseMessages {

    RESOURCE_NOT_FOUND("Resource not found"),
    USER_NOT_FOUND("User data not found"),
    USER_ALREADY_EXISTS("User already exists"),
    INVALID_INPUT("Provided input is invalid"),
    BAD_REQUEST("Bad request"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    UNAUTHORIZED("You are not authorized to perform this action"),
    FORBIDDEN("Access to this resource is forbidden"),
    CREATED_SUCCESSFULLY("Resource created successfully"),
    UPDATED_SUCCESSFULLY("Resource updated successfully"),
    DELETED_SUCCESSFULLY("Resource deleted successfully");

    private final String message;

    ResponseMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
