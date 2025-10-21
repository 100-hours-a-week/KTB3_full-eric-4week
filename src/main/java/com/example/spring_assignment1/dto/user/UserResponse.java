package com.example.spring_assignment1.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserResponse {
    @Schema(description = "사용자 ID", example = "1")
    private Long id;
    @Schema(description = "사용자 이메일", example = "eric@kakao.com")
    private String email;
    @Schema(description = "사용자 닉네임", example = "eric")
    private String nickname;

    public UserResponse(Long id, String email, String nickname) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getNickname() { return nickname; }
}
