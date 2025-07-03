package com.interflow.userservice.controller;

import com.interflow.userservice.service.UserService;
import com.interflow.userservice.util.dto.request.UserCreationDto;
import com.interflow.userservice.util.dto.response.User;
import com.interflow.userservice.util.dto.response.UserLargeDetails;
import com.interflow.userservice.util.dto.response.UserShortDetails;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable UUID id) {
        try {
            UserLargeDetails userDetails = userService.largeDetailsFromEntity(id);
            return ResponseEntity.ok(userDetails);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody @Valid UserCreationDto userData) {
        try {
            User createdUser = userService.createUser(userData);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create user");
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserShortDetails>> searchUsersByUserName(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        List<UserShortDetails> result = userService.shortDetailsFromEntity(keyword, page, size);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable UUID id, @RequestBody UserCreationDto updateData) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Update functionality is not yet implemented.");
    }
}
