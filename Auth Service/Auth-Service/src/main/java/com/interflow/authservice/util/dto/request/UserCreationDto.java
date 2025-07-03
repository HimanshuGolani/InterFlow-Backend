package com.interflow.authservice.util.dto.request;

import jakarta.validation.constraints.*;

public record UserCreationDto(
        @NotBlank
        String userName,
        @Email(message = "The email is not in proper format.")
        String email,
        @Min(value = 6)
        @Max(value = 12)
        String password,
        @NotBlank
        String fullName,
        String imageUrl
        ) {}
