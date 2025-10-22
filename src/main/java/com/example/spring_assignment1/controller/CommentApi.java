package com.example.spring_assignment1.controller;

import com.example.spring_assignment1.constant.CustomResponseCode;
import com.example.spring_assignment1.dto.BaseResponse;
import com.example.spring_assignment1.dto.comment.CommentRequest;
import com.example.spring_assignment1.dto.comment.CommentResponse;
import com.example.spring_assignment1.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CommentApi {

    @Operation(summary="댓글 조회", description = "게시글의 해당하는 댓글을 전부 조회합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "댓글 조회 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 게시글 에러")
    })
    ResponseEntity<BaseResponse<List<CommentResponse>>> getCommentsByPost(@RequestParam Long postId);

    @Operation(summary="댓글 생성", description = "게시글 ID, 사용자 ID, 댓글 내용을 넣고 댓글을 생성합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "댓글 생성 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 게시글 에러"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 사용자 에러")
    })
    ResponseEntity<BaseResponse<CommentResponse>> createComment(@RequestBody CommentRequest request);

    @Operation(summary="댓글 수정", description = "게시글 ID, 사용자 ID, 댓글 내용을 넣고 댓글을 수정합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "댓글 수정 성공"),
            @ApiResponse(responseCode = "403", description = "사용자 권한 인가 실패 에러"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 댓글 에러")
    })
    ResponseEntity<BaseResponse<CommentResponse>> updateComment(@PathVariable Long id, @RequestBody CommentRequest request);

    @Operation(summary="댓글 삭제", description = "댓글을 삭제합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "댓글 삭제 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 뎃글 에러")
    })
    ResponseEntity<BaseResponse<Void>> deleteComment(@PathVariable Long id);
}
