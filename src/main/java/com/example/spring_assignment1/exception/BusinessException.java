package com.example.spring_assignment1.exception;

import com.example.spring_assignment1.constant.CustomResponseCode;

public class BusinessException extends RuntimeException {
    private CustomResponseCode errorCode;

    public BusinessException(CustomResponseCode errorCode) {
        super(errorCode.getMessage());//로깅 메세지 부분에 쓰임.
        this.errorCode = errorCode;
    }
    public CustomResponseCode getErrorCode() {
        return errorCode;
    }
}
