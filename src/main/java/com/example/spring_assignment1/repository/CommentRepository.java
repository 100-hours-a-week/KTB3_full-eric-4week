package com.example.spring_assignment1.repository;

import com.example.spring_assignment1.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CommentRepository {
    private final List<Comment> comments = new ArrayList<>();
    private Long nextId = 1L;
    public Comment save(Comment comment) {
        comment.setCommentId(nextId++);
        comments.add(comment);
        return comment;
    }

    public List<Comment> findByPostId(Long postId) {
        return comments.stream().filter(comment -> comment.getPostId().equals(postId)).toList();
    }
    public Optional<Comment> findByCommentId(Long commentId) {
        return comments.stream().filter(comment -> comment.getCommentId().equals(commentId)).findFirst();
    }
    public void delete(Long commentId) {
        comments.removeIf(comment -> comment.getCommentId().equals(commentId));
    }
}
