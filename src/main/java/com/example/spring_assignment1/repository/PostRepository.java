package com.example.spring_assignment1.repository;

import com.example.spring_assignment1.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    private final List<Post> posts = new ArrayList<>();
    private Long nextId = 1L;
    public Post save(Post post){
        post.setId(nextId++);
        posts.add(post);
        return post;
    }
    public List<Post> findAll() {
        return posts;
    }

    public Optional<Post> findById(Long id) {
        return posts.stream().filter(post -> post.getId().equals(id)).findFirst();
    }

    public void delete(Long id) {
        posts.removeIf(post -> post.getId().equals(id));
    }
}
