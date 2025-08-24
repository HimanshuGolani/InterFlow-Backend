package com.interflow.userservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "users",
        indexes = {
                @Index(
                        name = "idx_username",
                        columnList = "userName"
                )}
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String userName;

    private String email;

    private String password;

    private String fullName;

    private String bio;

    private String profileImageUrl;

    private String location;

    private String company;

    private String position;

    private String role;

    private LocalDate joiningDate;

    private List<UUID> questionIds;

    private List<UUID> answeredQuestionsIds;

    private long totalUpVotes;

    private long profileVisits;

    private List<UUID> savedQuestions;

    private List<String> badges;

}
