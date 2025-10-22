package com.example.spring_assignment1.repository;

import com.example.spring_assignment1.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PublicPostRepository implements PostRepository {
    /*
    private final List<Post> posts = new ArrayList<>();
    AtomicLong nextId = new AtomicLong(1);

    public Post save(Post post){
        post.setId(nextId.getAndIncrement());
        posts.add(post); //리스트에 회원정보가 저장이 됩니다.
        return post;
    }

     */
    private final Map<Long, Post> posts = new HashMap<>();
    AtomicLong nextId = new AtomicLong(1);

    public Post save(Post post){
        if(post.getId() == null){
            post=post.initId(nextId.getAndIncrement());
        }
        posts.put(post.getId(), post);
        return post;
    }

    public List<Post> findAll() {
        return posts.values().stream().sorted(Comparator.comparing(Post::getCreatedAt).reversed()).toList();
    }

    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(posts.get(id));
        //return posts.stream().filter(post -> post.getId().equals(id)).findFirst();
    }

    public void delete(Long id) {
        posts.remove(id);
        //posts.removeIf(post -> post.getId().equals(id));
    }
}
