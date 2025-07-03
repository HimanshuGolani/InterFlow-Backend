package com.interflow.userservice.service;

import com.interflow.userservice.util.dto.request.UserCreationDto;
import com.interflow.userservice.util.dto.response.User;
import com.interflow.userservice.util.dto.response.UserLargeDetails;
import com.interflow.userservice.util.dto.response.UserShortDetails;

import java.util.List;
import java.util.UUID;

public interface UserService {

  User createUser(UserCreationDto data);
  List<UserShortDetails> shortDetailsFromEntity(String userName);
  UserLargeDetails largeDetailsFromEntity(UUID userId);
}
