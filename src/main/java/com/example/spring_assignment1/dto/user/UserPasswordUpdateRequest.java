package com.example.spring_assignment1.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserPasswordUpdateRequest {
    @Schema(description = "사용자 현재 비밀번호", example = "test1234")
    private String currentPassword;
    @Schema(description = "사용자 변경 비밀번호", example = "modified1234")
    private String newPassword;
    public String getCurrentPassword() {
        return currentPassword;
    }
    public String getNewPassword() {
        return newPassword;
    }
}
