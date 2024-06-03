package com.usernation.dev.service;

import com.usernation.dev.dto.CreateUserRequest;
import com.usernation.dev.dto.Response;
import com.usernation.dev.entity.User;

import java.util.List;

public interface UserService {
    List<Response> getAllUsers();

    User createUser(CreateUserRequest request);

    void deleteUser(Integer userId);

    User getUserById(Integer userId);

}