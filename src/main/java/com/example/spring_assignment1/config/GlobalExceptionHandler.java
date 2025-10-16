package com.example.spring_assignment1.config;

import com.example.spring_assignment1.constant.CustomResponseCode;
import com.example.spring_assignment1.dto.ApiResponse;
import com.example.spring_assignment1.exception.BusinessException;
import com.example.spring_assignment1.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Void>> handleBusinessException(BusinessException e) {
        return ResponseUtil.error(e.getErrorCode());
    }

    @ExceptionHandler(Exception.class) //특정 예외를 제외한 나머지 모든 예외
    public ResponseEntity<ApiResponse<Void>> handleException(Exception e) {
        log.error("서버 내부 오류",e); //스택 트레이스 반환, printStackTrace는 쓰지 말 것.
        return ResponseUtil.error(CustomResponseCode.INTERNAL_SERVER_ERROR);
    }
}
