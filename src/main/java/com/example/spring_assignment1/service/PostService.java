package com.example.spring_assignment1.service;

import com.example.spring_assignment1.constant.CustomResponseCode;
import com.example.spring_assignment1.domain.Post;
import com.example.spring_assignment1.domain.User;
import com.example.spring_assignment1.dto.post.GetPostsResponse;
import com.example.spring_assignment1.dto.post.PostRequest;
import com.example.spring_assignment1.dto.post.PostResponse;
import com.example.spring_assignment1.exception.BusinessException;
import com.example.spring_assignment1.repository.PostRepository;
import com.example.spring_assignment1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    private GetPostsResponse togetPostsResponse(Post post) {
        return new GetPostsResponse(post.getId(),post.getTitle(),post.getLikes(),post.getComments(), post.getViews(), post.getCreatedAt(), post.getUpdatedAt(), post.getAuthorId(), post.getAuthorNickname());
    }

    public List<GetPostsResponse> getAllPosts() {
        return postRepository.findAll().stream().map(post->this.togetPostsResponse(post)).toList();
    }

    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new BusinessException(CustomResponseCode.POST_NOT_FOUND));
        post.increaseViews();
        return toResponse(post);
    }

    public PostResponse createPost(PostRequest req) {
        User author = userRepository.findById(req.getUserId()).orElseThrow(() -> new BusinessException(CustomResponseCode.USER_NOT_FOUND));
        Post post = new Post(null, req.getTitle(), req.getContent(),0,0,0, LocalDateTime.now(), LocalDateTime.now(),author.getId(),author.getNickname());
        return toResponse(postRepository.save(post));
    }

    public PostResponse updatePost(Long id, PostRequest req) {
        Post post = postRepository.findById(id).orElseThrow(() -> new BusinessException(CustomResponseCode.POST_NOT_FOUND));
        if(!post.getAuthorId().equals(req.getUserId())){
            throw new BusinessException(CustomResponseCode.FORBIDDEN_ERROR);
        }
        Post updatedPost = post.updatePost(req.getTitle(), req.getContent());
        postRepository.save(updatedPost);
        return toResponse(updatedPost);
    }

    public void deletePost(Long id) {
        postRepository.findById(id).orElseThrow(() -> new BusinessException(CustomResponseCode.POST_NOT_FOUND));
        postRepository.delete(id);
    }

    private PostResponse toResponse(Post post) {
        User author = userRepository.findById(post.getAuthorId()).orElseThrow(() -> new BusinessException(CustomResponseCode.USER_NOT_FOUND));
        return new PostResponse(post.getId(), post.getTitle(), post.getContent(), post.getLikes(), post.getComments(), post.getViews(), post.getCreatedAt(), post.getUpdatedAt(), post.getAuthorId(), author.getNickname());
    }
}
