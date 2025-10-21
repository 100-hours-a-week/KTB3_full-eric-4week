package com.example.spring_assignment1.controller;

import com.example.spring_assignment1.constant.CustomResponseCode;
import com.example.spring_assignment1.dto.BaseResponse;
import com.example.spring_assignment1.dto.comment.CommentRequest;
import com.example.spring_assignment1.dto.comment.CommentResponse;
import com.example.spring_assignment1.service.CommentService;
import com.example.spring_assignment1.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService) { this.commentService = commentService; }

    @GetMapping("/post")
    public ResponseEntity<BaseResponse<List<CommentResponse>>> getCommentsByPost(@RequestParam Long postId) {
        return ResponseUtil.success(commentService.getComments(postId));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<CommentResponse>> createComment(@RequestBody CommentRequest request) {
        return ResponseUtil.success(CustomResponseCode.CREATED, commentService.createComment(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BaseResponse<CommentResponse>> updateComment(@PathVariable Long id, @RequestBody CommentRequest request) {
        return ResponseUtil.success(commentService.updateComment(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseUtil.success(CustomResponseCode.NO_CONTENT, null);
    }
}
