package com.example.spring_assignment1.dto.post;

import java.time.LocalDateTime;

public class GetPostsResponse {
    private Long postId;
    private String title;
    private String authorNickname;
    private int likes;
    private int comments;
    private int views;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long authorId;

    public GetPostsResponse(Long postId, String title,int likes, int comments, int views, LocalDateTime createdAt, LocalDateTime updatedAt, Long authorId, String authorNickname) {
        this.postId = postId;
        this.title = title;
        this.likes = likes;
        this.comments = comments;
        this.views = views;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.authorId = authorId;
        this.authorNickname = authorNickname;
    }

    public Long getPostId() { return postId; }
    public String getTitle() { return title; }
    public int getLikes() { return likes; }
    public int getComments() { return comments; }
    public int getViews() { return views; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public Long getAuthorId() { return authorId; }
    public String getAuthorNickname() { return authorNickname; }
}
