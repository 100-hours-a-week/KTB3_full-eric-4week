package com.example.spring_assignment1.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
public class Comment {
    private Long postId;
    private Long Id;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long userId;
    private String commenterNickname;

    public Comment(Long postId, Long Id, String content, LocalDateTime createdAt, LocalDateTime updatedAt,Long userId, String commenterNickname) {
        this.postId = postId;
        this.Id = Id;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
        this.commenterNickname = commenterNickname;
    }
    public Long getPostId() { return postId; }
    public Long getId() { return Id; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public Long getUserId() { return userId; }
    public String getCommenterNickname() { return commenterNickname; }

    public Comment initId(Long id){
        return this.toBuilder().Id(id).build();
    }
    public Comment updateComment(String content){
        return this.toBuilder().content(content).updatedAt(LocalDateTime.now()).build();
    }

    public boolean isMyCommentByUserId(Long currentUserId) {
        return userId.equals(currentUserId);
    }
}
