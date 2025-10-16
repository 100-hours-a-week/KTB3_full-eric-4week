package com.example.spring_assignment1.controller;

import com.example.spring_assignment1.constant.CustomResponseCode;
import com.example.spring_assignment1.dto.ApiResponse;
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
    public ResponseEntity<ApiResponse<List<CommentResponse>>> getCommentsByPost(@RequestParam Long postId) {
        return ResponseUtil.success(commentService.getComments(postId));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CommentResponse>> createComment(@RequestBody CommentRequest request) {
        return ResponseUtil.success(CustomResponseCode.CREATED, commentService.createComment(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<CommentResponse>> updateComment(@PathVariable Long id, @RequestBody CommentRequest request) {
        return ResponseUtil.success(commentService.updateComment(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseUtil.success(CustomResponseCode.NO_CONTENT, null);
    }
}
