package com.interflow.userservice.repository;

import com.interflow.userservice.entity.User;
import com.interflow.userservice.util.dto.response.UserShortDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends Repository<User, UUID> {

    User save(User user);

    Optional<User> findById(UUID id);

    @Query("""
        SELECT new com.interflow.userservice.util.dto.response.UserShortDetails(
            u.id,
            u.userName,
            u.fullName,
            u.company,
            u.profileImageUrl,
            u.position,
            u.badges
        )
        FROM User u
        WHERE LOWER(u.userName) LIKE LOWER(CONCAT('%', :keyword, '%'))
    """)
    List<UserShortDetails> searchByUserName(@Param("keyword") String keyword, Pageable pageable);
}
