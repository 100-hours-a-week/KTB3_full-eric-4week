package com.example.spring_assignment1.dto.comment;

import io.swagger.v3.oas.annotations.media.Schema;

public class CommentRequest {
    @Schema(description = "게시글 ID", example = "1")
    private Long postId;
    @Schema(description = "사용자 ID", example = "1")
    private Long userId;
    @Schema(description = "댓글 내용", example = "API연습 화이팅!")
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
