package com.example.spring_assignment1.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

public class UserSignupRequest { //@RequestBody로
    @Schema(description = "사용자 이메일", example = "eric@kakao.com")
    @Email
    private String email;
    @Schema(description = "사용자 비밀번호", example = "test1234")
    private String password;
    @Schema(description = "사용자 닉네임", example = "eric")
    private String nickname;
    @Schema(description = "사용자 프로필 사진", example = "https://image.kr/img.jpg")
    private String profile_image;

    public String getEmail() { return email;}
    public String getPassword() { return password; }
    public String getNickname() { return nickname; }
    public String getProfile_image() { return profile_image; }
}
