package com.example.employee_backend.auth.service;

import com.example.employee_backend.auth.dto.AuthResponse;
import com.example.employee_backend.auth.dto.LoginRequest;
import com.example.employee_backend.auth.dto.SignupRequest;
import com.example.employee_backend.auth.repository.UserRepository;
import com.example.employee_backend.auth.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.employee_backend.auth.entity.User;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    //First make Repository Connection Here

    private final UserRepository userRepository;

    // as here we need password also so make its connection too

    private final PasswordEncoder passwordEncoder;

    // as we are not using the lombok so we will make there constructor


    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponse signup(SignupRequest request) {
        // check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        // encrypt password
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // create user
        User user = new User(
                request.getEmail(),
                encodedPassword,
                "ROLE_USER"
        );

        userRepository.save(user);
        // token will be added later (JWT)
        return new AuthResponse("USER_REGISTERED_SUCCESSFULLY");
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = JwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token);
    }
}
