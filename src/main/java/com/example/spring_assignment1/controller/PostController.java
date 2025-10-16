package com.example.spring_assignment1.controller;

import com.example.spring_assignment1.constant.CustomResponseCode;
import com.example.spring_assignment1.dto.ApiResponse;
import com.example.spring_assignment1.dto.post.GetPostsResponse;
import com.example.spring_assignment1.dto.post.PostRequest;
import com.example.spring_assignment1.dto.post.PostResponse;
import com.example.spring_assignment1.service.PostService;
import com.example.spring_assignment1.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    public PostController(PostService postService) { this.postService = postService; }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetPostsResponse>>> getPosts() {
        return ResponseUtil.success(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponse>> getPost(@PathVariable Long id) {
        return ResponseUtil.success(postService.getPost(id));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PostResponse>> createPost(@RequestBody PostRequest request) {
        return ResponseUtil.success(CustomResponseCode.CREATED, postService.createPost(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponse>> updatePost(@PathVariable Long id, @RequestBody PostRequest request) {
        return ResponseUtil.success(postService.updatePost(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseUtil.success(CustomResponseCode.NO_CONTENT, null);
    }
}
