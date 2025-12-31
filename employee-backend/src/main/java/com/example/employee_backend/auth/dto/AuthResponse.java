package com.example.employee_backend.auth.dto;

public class AuthResponse {
    private String token;

    //constructor
    public AuthResponse(String token) {
        this.token = token;
    }

    //getter

    public String getToken() {
        return token;
    }

}
