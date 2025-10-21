package com.example.spring_assignment1.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class BaseResponse<T> {
    @Schema(description = "응답 성공 여부", example = "True")
    private boolean success;
    @Schema(description = "응답 코드", example = "SUCCESS")
    private String code;
    @Schema(description = "응답 메세지", example = "요청 정상 처리")
    private String message;
    private T data;

    private BaseResponse(boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> BaseResponse<T> success(String message, T data) {
        return new BaseResponse<>(true, "SUCCESS", message, data);
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(true, "SUCCESS", "요청이 성공적으로 처리되었습니다.", data);
    } //특정 Success 제외 대부분의 성공 처리 Response

    public static <T> BaseResponse<T> error(String code, String message) {
        return new BaseResponse<>(false, code, message, null);
    }

    public boolean isSuccess() { return success; }
    public String getCode() { return code; }
    public String getMessage() { return message; }
    public T getData() { return data; }
}
