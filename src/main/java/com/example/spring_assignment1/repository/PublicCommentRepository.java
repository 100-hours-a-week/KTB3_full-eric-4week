package com.example.spring_assignment1.repository;

import com.example.spring_assignment1.domain.Comment;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PublicCommentRepository implements CommentRepository {
    /*
    private final List<Comment> comments = new ArrayList<>();
    AtomicLong nextId = new AtomicLong(1);

    public Comment save(Comment comment){
        comment.setCommentId(nextId.getAndIncrement());
        comments.add(comment); //리스트에 회원정보가 저장이 됩니다.
        return comment;
    }
     */
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
        //return comments.values().stream().sorted(Comparator.comparing(Comment::getCreatedAt).reversed()).toList();
        //return comments.stream().filter(comment -> comment.getPostId().equals(postId)).toList();
    }
    public Optional<Comment> findByCommentId(Long commentId) {
        return Optional.ofNullable(comments.get(commentId));
        //return comments.stream().filter(comment -> comment.getCommentId().equals(commentId)).findFirst();
    }
    public void delete(Long commentId) {
        comments.remove(commentId);
        //comments.removeIf(comment -> comment.getCommentId().equals(commentId));
    }
}
