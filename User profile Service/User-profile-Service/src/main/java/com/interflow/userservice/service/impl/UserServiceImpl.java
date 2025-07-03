package com.interflow.userservice.service.impl;

import com.interflow.userservice.repository.UserRepository;
import com.interflow.userservice.service.UserService;
import com.interflow.userservice.util.dto.request.UserCreationDto;
import com.interflow.userservice.util.dto.response.User;
import com.interflow.userservice.util.dto.response.UserLargeDetails;
import com.interflow.userservice.util.dto.response.UserShortDetails;
import com.interflow.userservice.util.mapping.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public User createUser(UserCreationDto data) {
        var user = UserMapper.INSTANCE.userToEntity(data);
        var createdUser = userRepository.save(user);
        return UserMapper.INSTANCE.userToResponse(createdUser);
    }

    @Override
    public List<UserShortDetails> shortDetailsFromEntity(String userNameKeyword, int page, int size) {
        var pageRequest = PageRequest.of(page, size);
        return userRepository.searchByUserName(userNameKeyword, pageRequest);
    }

    @Override
    public UserLargeDetails largeDetailsFromEntity(UUID userId) {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        return UserMapper.INSTANCE.largeDetailsFromEntity(user);
    }
}
