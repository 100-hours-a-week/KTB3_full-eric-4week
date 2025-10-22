package com.example.spring_assignment1.repository;

import com.example.spring_assignment1.domain.Comment;

import java.util.Optional;

public interface CommentRepository {
    Comment save(Comment comment);

    Optional<Comment> findByPostId(Long postId);
    Optional<Comment> findByCommentId(Long commentId);
    void delete(Long commentId);
}
