package com.example.spring_assignment1.repository;

import com.example.spring_assignment1.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    List<Post> findAll();
    Optional<Post> findById(Long id);
    void delete(Long id);
}
