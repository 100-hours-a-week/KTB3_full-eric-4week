package com.example.spring_assignment1.service;

import com.example.spring_assignment1.constant.CustomResponseCode;
import com.example.spring_assignment1.domain.Comment;
import com.example.spring_assignment1.domain.Post;
import com.example.spring_assignment1.domain.User;
import com.example.spring_assignment1.dto.comment.CommentRequest;
import com.example.spring_assignment1.dto.comment.CommentResponse;
import com.example.spring_assignment1.exception.BusinessException;
import com.example.spring_assignment1.repository.CommentRepository;
import com.example.spring_assignment1.repository.PostRepository;
import com.example.spring_assignment1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }
    public CommentResponse createComment(CommentRequest req) {
        User user = userRepository.findById(req.getUserId()).orElseThrow(() -> new BusinessException(CustomResponseCode.USER_NOT_FOUND));
        Post post = postRepository.findById(req.getPostId()).orElseThrow(() -> new BusinessException(CustomResponseCode.POST_NOT_FOUND));
        Comment comment = new Comment(post.getId(), null, req.getContent(), LocalDateTime.now(), java.time.LocalDateTime.now(), user.getId(), user.getNickname());
        post.increaseComments();
        return toResponse(commentRepository.save(comment));
    }

    public List<CommentResponse> getComments(Long postId) {
        postRepository.findById(postId).orElseThrow(() -> new BusinessException(CustomResponseCode.POST_NOT_FOUND));
        return commentRepository.findByPostId(postId).stream().map(this::toResponse).toList();
    }

    public CommentResponse updateComment(Long id, CommentRequest req) {
        Comment comment = commentRepository.findByCommentId(id).orElseThrow(() -> new BusinessException(CustomResponseCode.COMMENT_NOT_FOUND));
        if(!comment.getUserId().equals(req.getUserId())) {
            throw new BusinessException(CustomResponseCode.FORBIDDEN_ERROR);
        }
        comment.update(req.getContent());
        return toResponse(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.findByCommentId(id).orElseThrow(() -> new BusinessException(CustomResponseCode.COMMENT_NOT_FOUND));
        commentRepository.delete(id);
    }

    private CommentResponse toResponse(Comment comment) {
        User user = userRepository.findById(comment.getUserId()).orElseThrow(() -> new BusinessException(CustomResponseCode.USER_NOT_FOUND));
        return new CommentResponse(comment.getPostId(), comment.getCommentId(), comment.getContent(), comment.getCreatedAt(), comment.getUpdatedAt(), comment.getUserId(), comment.getCommenterNickname());
    }
}
