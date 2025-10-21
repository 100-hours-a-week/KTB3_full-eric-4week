package com.example.spring_assignment1.repository;

import com.example.spring_assignment1.domain.Post;
import com.example.spring_assignment1.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepository {
    private final List<Post> posts = new ArrayList<>();
    AtomicLong nextId = new AtomicLong(1);

    public Post save(Post post){
        post.setId(nextId.getAndIncrement());
        posts.add(post); //리스트에 회원정보가 저장이 됩니다.
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
