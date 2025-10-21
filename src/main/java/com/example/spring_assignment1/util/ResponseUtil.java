package com.example.spring_assignment1.util;

import com.example.spring_assignment1.constant.CustomResponseCode;
import com.example.spring_assignment1.dto.BaseResponse;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<BaseResponse<T>> success(CustomResponseCode code, T data) {
        return ResponseEntity.status(code.getStatus()).body(BaseResponse.success(code.getMessage(), data));
    }

    public static <T> ResponseEntity<BaseResponse<T>> success(T data) {
        return ResponseEntity.status(CustomResponseCode.SUCCESS.getStatus()).body(BaseResponse.success(CustomResponseCode.SUCCESS.getMessage(), data));
    }

    public static ResponseEntity<BaseResponse<Void>> error(CustomResponseCode code) {
        return ResponseEntity.status(code.getStatus()).body(BaseResponse.error(code.getCode(), code.getMessage()));
    }
}
