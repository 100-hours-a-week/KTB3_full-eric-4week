package com.example.spring_assignment1.dto.post;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public class GetPostsResponse {
    @Schema(description = "게시글 ID", example = "1")
    private Long postId;
    @Schema(description = "게시글 제목", example = "API 연습하기")
    private String title;
    @Schema(description = "좋아요 개수", example = "9")
    private int likes;
    @Schema(description = "댓글 개수", example = "99")
    private int comments;
    @Schema(description = "조회수 개수", example = "999")
    private int views;
    @Schema(description = "게시글 생성 시간", example = "2025-10-16T18:44:16.327059")
    private LocalDateTime createdAt;
    @Schema(description = "게시글 업데이트 시간", example = "2025-10-16T18:44:16.327142")
    private LocalDateTime updatedAt;
    @Schema(description = "게시글 작성자 ID", example = "1")
    private Long authorId;
    @Schema(description = "게시글 작성자 닉네임", example = "eric")
    private String authorNickname;

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
