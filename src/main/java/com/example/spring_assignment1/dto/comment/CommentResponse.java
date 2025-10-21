package com.example.spring_assignment1.dto.comment;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public class CommentResponse {
    @Schema(description = "게시글 ID", example = "1")
    private Long postId;
    @Schema(description = "댓글 ID", example = "1")
    private Long commentId;
    @Schema(description = "댓글 내용", example = "API연습 화이팅!")
    private String content;
    @Schema(description = "댓글 생성 시간", example = "2025-10-16T18:44:16.327059")
    private LocalDateTime createdAt;
    @Schema(description = "댓글 생성 시간", example = "2025-10-16T18:44:16.327059")
    private LocalDateTime updatedAt;
    @Schema(description = "사용자 ID", example = "1")
    private Long userId;
    @Schema(description = "댓글 작성자 닉네임", example = "eric")
    private String commenterNickname;

    public CommentResponse(Long postId, Long commentId, String content, LocalDateTime createdAt, LocalDateTime updatedAt, Long userId, String commenterNickname) {
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
}


