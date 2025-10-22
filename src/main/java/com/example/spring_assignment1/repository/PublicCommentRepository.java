package com.example.spring_assignment1.repository;

import com.example.spring_assignment1.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PublicCommentRepository implements CommentRepository {
    private final Map<Long, Comment> comments = new HashMap<>();
    AtomicLong nextId = new AtomicLong(1);

    public Comment save(Comment comment){
        if(comment.getId() == null){
            comment = comment.initId(nextId.getAndIncrement());
        }
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Optional<Comment> findByPostId(Long postId) {
        return Optional.ofNullable(comments.get(postId));
    }
    public Optional<Comment> findByCommentId(Long commentId) {
        return Optional.ofNullable(comments.get(commentId));
    }
    public void delete(Long commentId) {
        comments.remove(commentId);
    }
}
