package com.example.spring_assignment1.dto.user;

import jakarta.validation.constraints.Email;

public class UserSignupRequest { //@RequestBody로
    @Email
    private String email;

    private String password;
    private String nickname;
    private String profile_image;

    public String getEmail() { return email;}
    public String getPassword() { return password; }
    public String getNickname() { return nickname; }
    public String getProfile_image() { return profile_image; }
}
