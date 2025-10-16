package com.example.spring_assignment1.dto.comment;

public class CommentRequest {
    private Long postId;
    private Long userId;
    private String content;

    public Long getPostId() {
        return postId;
    }
    public Long getUserId() {
        return userId;
    }
    public String getContent() {
        return content;
    }

}
