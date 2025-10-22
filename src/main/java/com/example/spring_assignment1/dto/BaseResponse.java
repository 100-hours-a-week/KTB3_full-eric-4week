package com.example.spring_assignment1.dto;

import com.example.spring_assignment1.constant.CustomResponseCode;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonPropertyOrder({"success","code","message","data"})
public class BaseResponse<T> {
    @Schema(description = "응답 성공 여부", example = "True")
    private boolean success;
    @Schema(description = "응답 코드", example = "SUCCESS")
    //private String code;
    private CustomResponseCode customResponseCode;
    @Schema(description = "응답 메세지", example = "요청 정상 처리")
    private String message;
    private T data;


    private BaseResponse(boolean success, CustomResponseCode customResponseCode, String message, T data) {
        this.success = success;
        this.customResponseCode = customResponseCode;
        this.message = message;
        this.data = data;
    }

    public static <T> BaseResponse<T> success(CustomResponseCode customResponseCode, T data) {
        return new BaseResponse<>(true, customResponseCode, customResponseCode.getMessage(), data);
    }

    public static <T> BaseResponse<T> success(T data) {
        //return new BaseResponse<>(true, "SUCCESS", "요청이 성공적으로 처리되었습니다.", data);
        return success(CustomResponseCode.SUCCESS, data);
    } //특정 Success 제외 대부분의 성공 처리 Response

    public static <T> BaseResponse<T> error(CustomResponseCode customResponseCode) {
        return new BaseResponse<>(false,customResponseCode, customResponseCode.getMessage(), null);
    }

    public boolean isSuccess() { return success; }
    public CustomResponseCode getCode() { return customResponseCode; }
    public String getMessage() { return message; }
    public T getData() { return data; }


}
