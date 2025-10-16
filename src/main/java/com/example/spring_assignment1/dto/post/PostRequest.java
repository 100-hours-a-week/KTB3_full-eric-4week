package com.example.spring_assignment1.dto.post;

public class PostRequest {
    private String title;
    private String content;
    private Long userId;

    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public Long getUserId() {
        return userId;
    }
}
