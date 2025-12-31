package com.example.employee_backend.auth.dto;

public class SignupRequest {
    private String email;
    private String password;

    // as we are not using lombok

    public SignupRequest() {}

    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}
