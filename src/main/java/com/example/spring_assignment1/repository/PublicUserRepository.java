package com.example.spring_assignment1.repository;

import com.example.spring_assignment1.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PublicUserRepository implements UserRepository {
    private final Map<Long, User> users = new HashMap<>();
    AtomicLong nextId = new AtomicLong(1);

    public User save(User user){
        if(user.getId()==null){
            user = user.initId(nextId.getAndIncrement());
        }
        users.put(user.getId(), user);
        return user;
    }

    public Optional<User> findById(Long id){
        return Optional.ofNullable(users.get(id));
    }
    public Optional<User> findByEmail(String email){
        return users.values().stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }
    public boolean existsByEmail(String email){
        return users.values().stream().anyMatch(user -> user.getEmail().equals(email));
    }
    public boolean existsByNickname(String nickname){
        return users.values().stream().anyMatch(user -> user.getNickname().equals(nickname));
    }
    public void delete(Long id){
        users.remove(id);
    }
}
