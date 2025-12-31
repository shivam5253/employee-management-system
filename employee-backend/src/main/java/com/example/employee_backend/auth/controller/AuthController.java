package com.example.employee_backend.auth.controller;

import com.example.employee_backend.auth.dto.AuthResponse;
import com.example.employee_backend.auth.dto.LoginRequest;
import com.example.employee_backend.auth.dto.SignupRequest;
import com.example.employee_backend.auth.service.AuthService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    //constructor
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public AuthResponse signup(@RequestBody SignupRequest request) {
        return authService.signup(request);
    }
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

}

