package com.example.spring_assignment1.dto.auth;

import jakarta.validation.constraints.Email;

public class UserLoginRequest {
    @Email
    private String email;
    private String password;

    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
