package com.interflow.userservice.util.dto.response;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public record UserLargeDetails(
        UUID id,
        String userName,
        String email,
        String fullName,
        String bio,
        String company,
        String profileImageUrl,
        String position,
        long totalUpVotes,
        long profileVisits,
//        after the question service is implemented please send this questions list as per the
//        pagination not the ids.
        List<UUID> questionIds,
        List<String> badges
) {
}
