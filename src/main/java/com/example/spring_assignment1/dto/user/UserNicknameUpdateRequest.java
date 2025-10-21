package com.example.spring_assignment1.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserNicknameUpdateRequest {
    @Schema(description = "사용자 닉네임", example = "eric")
    private String nickname;

    public String getNickname() {
        return nickname;
    }
}
