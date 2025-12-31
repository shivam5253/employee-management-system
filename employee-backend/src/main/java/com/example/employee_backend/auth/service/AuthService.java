package com.example.employee_backend.auth.service;
//STEP 2 — CREATE AUTH SERVICE INTERFACE

import com.example.employee_backend.auth.dto.AuthResponse;
import com.example.employee_backend.auth.dto.LoginRequest;
import com.example.employee_backend.auth.dto.SignupRequest;

public interface AuthService {

    //Make connection of Dto here

    //first one for signup
    AuthResponse signup(SignupRequest request);

    //2nd one for login
    AuthResponse login(LoginRequest request);

}


//STEP 3 — AUTH SERVICE IMPLEMENTATION (SIGNUP LOGIC)