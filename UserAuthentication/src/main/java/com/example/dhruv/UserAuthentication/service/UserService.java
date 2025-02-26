package com.example.dhruv.UserAuthentication.service;

import com.example.dhruv.UserAuthentication.model.User;
import com.example.dhruv.UserAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {

        if(userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if(userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        return userRepository.save(user);
    }

    public User loginUser(String username, String password) {

        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new RuntimeException("User not found");
        }

        if(!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}
