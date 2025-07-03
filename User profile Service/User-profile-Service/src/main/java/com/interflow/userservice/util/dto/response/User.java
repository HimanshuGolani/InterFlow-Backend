package com.interflow.userservice.util.dto.response;

import java.util.UUID;

public record User(
        UUID id,
        String role,
        String userName
) {
}
