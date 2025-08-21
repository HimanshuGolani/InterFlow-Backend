package com.interflow.userservice.controller;

import com.interflow.userservice.service.UserService;
import com.interflow.userservice.util.dto.request.UserCreationDto;
import com.interflow.userservice.util.dto.request.UserProfileUpdate;
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
    public ResponseEntity<UserLargeDetails> findUserById(@PathVariable UUID id) {
            UserLargeDetails userDetails = userService.largeDetailsFromEntity(id);
            return ResponseEntity.ok(userDetails);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserCreationDto userData) {
            User createdUser = userService.createUser(userData);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
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

    @PutMapping("/{id}/profile")
    public ResponseEntity<UserLargeDetails> updateUserById(@PathVariable UUID id, @RequestBody UserProfileUpdate updateData) {
        UserLargeDetails updatedUser = userService.findUserByIdAndUpdate(id,updateData);
        return ResponseEntity.ok(updatedUser);
    }


}
