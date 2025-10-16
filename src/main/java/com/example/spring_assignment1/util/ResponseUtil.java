package com.example.spring_assignment1.util;

import com.example.spring_assignment1.constant.CustomResponseCode;
import com.example.spring_assignment1.dto.ApiResponse;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<ApiResponse<T>> success(CustomResponseCode code, T data) {
        return ResponseEntity.status(code.getStatus()).body(ApiResponse.success(code.getMessage(), data));
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(T data) {
        return ResponseEntity.status(CustomResponseCode.SUCCESS.getStatus()).body(ApiResponse.success(CustomResponseCode.SUCCESS.getMessage(), data));
    }

    public static ResponseEntity<ApiResponse<Void>> error(CustomResponseCode code) {
        return ResponseEntity.status(code.getStatus()).body(ApiResponse.error(code.getCode(), code.getMessage()));
    }
}
