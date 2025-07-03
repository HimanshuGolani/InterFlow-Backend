package com.interflow.userservice.service.impl;

import com.interflow.userservice.repository.UserRepository;
import com.interflow.userservice.service.UserService;
import com.interflow.userservice.util.dto.request.UserCreationDto;
import com.interflow.userservice.util.dto.response.User;
import com.interflow.userservice.util.dto.response.UserLargeDetails;
import com.interflow.userservice.util.dto.response.UserShortDetails;
import com.interflow.userservice.util.mapping.UserMapper;
import lombok.RequiredArgsConstructor;
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
        try {
            com.interflow.userservice.entity.User user = UserMapper.INSTANCE.userToEntity(data);
            com.interflow.userservice.entity.User createdUser = userRepository.save(user);
            return UserMapper.INSTANCE.userToResponse(createdUser);
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<UserShortDetails> shortDetailsFromEntity(String userName) {
        return List.of();
    }

    @Override
    public UserLargeDetails largeDetailsFromEntity(UUID userId) {
        return null;
    }


}
