package com.interflow.userservice.controller;

import com.interflow.userservice.service.UserService;
import com.interflow.userservice.util.dto.request.UserCreationDto;
import com.interflow.userservice.util.dto.response.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// get user profile by id
// update user profile by id
// create user

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> findByIdAndUpdate(){return null;}

    @PostMapping
    public ResponseEntity<?> saveUser(
            @RequestBody @Valid UserCreationDto userData
            ){
        User response = userService.createUser(userData);
        return new ResponseEntity<>( response, HttpStatus.PERMANENT_REDIRECT);
    }

}
