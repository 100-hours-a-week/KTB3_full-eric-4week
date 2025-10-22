package com.example.spring_assignment1.util;

import com.example.spring_assignment1.constant.CustomResponseCode;
import com.example.spring_assignment1.dto.BaseResponse;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<BaseResponse<T>> success(CustomResponseCode customResponseCode, T data) {
        return ResponseEntity.status(customResponseCode.getStatus()).body(BaseResponse.success(customResponseCode, data));
    }

    public static <T> ResponseEntity<BaseResponse<T>> success(T data) {
        return ResponseEntity.status(CustomResponseCode.SUCCESS.getStatus()).body(BaseResponse.success(CustomResponseCode.SUCCESS, data));
    }

    public static ResponseEntity<BaseResponse<Void>> error(CustomResponseCode customResponseCode) {
        return ResponseEntity.status(customResponseCode.getStatus()).body(BaseResponse.error(customResponseCode));
    }
}
