package com.example.spring_assignment1.domain;

import java.time.LocalDateTime;

public class Comment {
    private Long postId;
    private Long commentId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long userId;
    private String commenterNickname;

    public Comment(Long postId, Long commentId, String content, LocalDateTime createdAt, LocalDateTime updatedAt,Long userId, String commenterNickname) {
        this.postId = postId;
        this.commentId = commentId;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
        this.commenterNickname = commenterNickname;
    }
    public Long getPostId() { return postId; }
    public Long getCommentId() { return commentId; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public Long getUserId() { return userId; }
    public String getCommenterNickname() { return commenterNickname; }

    public void setCommentId(Long id) { this.commentId = id; }

    public void update(String content) {
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

}
