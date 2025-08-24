package com.interflow.userservice.service.impl;

import com.interflow.userservice.exception.custom.ResourceNotFoundException;
import com.interflow.userservice.exception.messages.ResponseMessages;
import com.interflow.userservice.repository.UserRepository;
import com.interflow.userservice.service.UserService;
import com.interflow.userservice.util.UserUpdater;
import com.interflow.userservice.util.dto.request.UserCreationDto;
import com.interflow.userservice.util.dto.request.UserProfileUpdate;
import com.interflow.userservice.util.dto.response.User;
import com.interflow.userservice.util.dto.response.UserLargeDetails;
import com.interflow.userservice.util.dto.response.UserShortDetails;
import com.interflow.userservice.util.mapping.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
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
                .orElseThrow(() -> new ResourceNotFoundException(ResponseMessages.RESOURCE_NOT_FOUND.getMessage() + userId));
        return UserMapper.INSTANCE.largeDetailsFromEntity(user);
    }

    @Override
    public UserLargeDetails findUserByIdAndUpdate(UUID id, UserProfileUpdate data) {

        com.interflow.userservice.entity.User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + id + " not found."));

        UserUpdater updater = new UserUpdater();

        updater.update(user::setBio, user::getBio, data.bio());
        updater.update(user::setCompany, user::getCompany, data.company());
        updater.update(user::setProfileImageUrl, user::getProfileImageUrl, data.profileImageUrl());
        updater.update(user::setPosition, user::getPosition, data.position());
        updater.update(user::setLocation, user::getLocation, data.location());

        if (updater.isChanged()) {
            user = userRepository.save(user);
            log.info("User [{}] updated successfully.", id);
        } else {
            log.info("No changes detected for User [{}]. Skipping update.", id);
        }

        return UserMapper.INSTANCE.largeDetailsFromEntity(user);
    }


//    implement routes for finding all the questions of a user by name and use grpc for that work

}
