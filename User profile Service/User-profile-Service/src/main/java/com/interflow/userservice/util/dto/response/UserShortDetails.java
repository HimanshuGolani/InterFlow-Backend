package com.interflow.userservice.util.dto.response;

import java.util.List;
import java.util.UUID;

public record UserShortDetails(
        UUID id,
        String userName,
        String fullName,
        String company,
        String profileImageUrl,
        String position,
        List<String> badges
) {
}
