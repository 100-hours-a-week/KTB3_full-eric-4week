package com.example.spring_assignment1.repository;

import com.example.spring_assignment1.domain.Comment;
import com.example.spring_assignment1.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CommentRepository {
    private final List<Comment> comments = new ArrayList<>();
    AtomicLong nextId = new AtomicLong(1);

    public Comment save(Comment comment){
        comment.setCommentId(nextId.getAndIncrement());
        comments.add(comment); //리스트에 회원정보가 저장이 됩니다.
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
