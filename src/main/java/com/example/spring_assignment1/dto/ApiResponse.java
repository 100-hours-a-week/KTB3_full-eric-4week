package com.example.spring_assignment1.dto;

public class ApiResponse<T> {
    private boolean success;
    private String code;
    private String message;
    private T data;

    private ApiResponse(boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, "SUCCESS", message, data);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "SUCCESS", "요청이 성공적으로 처리되었습니다.", data);
    } //특정 Success 제외 대부분의 성공 처리 Response

    public static <T> ApiResponse<T> error(String code, String message) {
        return new ApiResponse<>(false, code, message, null);
    }

    public boolean isSuccess() { return success; }
    public String getCode() { return code; }
    public String getMessage() { return message; }
    public T getData() { return data; }
}
