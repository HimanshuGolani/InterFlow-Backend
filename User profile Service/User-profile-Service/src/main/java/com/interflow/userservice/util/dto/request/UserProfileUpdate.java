package com.interflow.userservice.util.dto.request;

public record UserProfileUpdate(
        String bio,
        String profileImageUrl,
        String position,
        String location,
        String company
        ) {

}
