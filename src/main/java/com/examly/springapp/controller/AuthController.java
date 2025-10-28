package com.examly.springapp.controller;

import com.examly.springapp.dto.AuthRequest;
import com.examly.springapp.dto.AuthResponse;
import com.examly.springapp.model.User;
import com.examly.springapp.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
        try {
            User user = authService.register(request.getUsername(), request.getPassword());
            String token = "token_" + user.getId(); // Simple token
            return ResponseEntity.ok(new AuthResponse(token, user.getUsername()));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        try {
            User user = authService.login(request.getUsername(), request.getPassword());
            String token = "token_" + user.getId(); // Simple token
            return ResponseEntity.ok(new AuthResponse(token, user.getUsername()));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}