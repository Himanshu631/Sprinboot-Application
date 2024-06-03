package com.usernation.dev.service;

import com.usernation.dev.dto.CreateUserRequest;
import com.usernation.dev.dto.Response;
import com.usernation.dev.entity.User;
import com.usernation.dev.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplem implements UserService{

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Response> getAllUsers(){
        return userRepository.findAll().stream().map(
                user -> new Response(
                        user.getUserId(),user.getUserName(),user.getAccountType()
                )
        ).collect(Collectors.toList());
    }

    public User createUser(CreateUserRequest request){
        User user = new User();
        user.setUserName(request.getUserName());
        user.setAccountType(request.getAccountType());
        User savedUser = userRepository.save(user);

        return new User(savedUser.getUserId(),savedUser.getUserName(),savedUser.getAccountType());
    }

    @Transactional
    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId.longValue())
                .orElseThrow(() -> new EntityNotFoundException(
                "No user found with userId "+userId));
        userRepository.delete(user);
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findByUserId(userId);
    }

}
