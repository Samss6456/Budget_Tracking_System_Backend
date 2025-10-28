package com.examly.springapp.service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User register(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        return userRepository.save(new User(username, password));
    }
    
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials");
        }
        return user;
    }
}