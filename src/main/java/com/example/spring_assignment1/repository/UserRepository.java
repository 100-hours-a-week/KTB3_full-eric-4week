package com.example.spring_assignment1.repository;

import com.example.spring_assignment1.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
    private Long nextId=1L;

    public User save(User user){
        user.setId(nextId++);
        users.add(user); //리스트에 회원정보가 저장이 됩니다.
        return user;
    }

    public Optional<User> findById(Long id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
    public Optional<User> findByEmail(String email){
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }
    public boolean existsByEmail(String email){
        return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }
    public boolean existsByNickname(String nickname){
        return users.stream().anyMatch(user -> user.getNickname().equals(nickname));
    }
    public void delete(Long id){
        users.removeIf(user -> user.getId().equals(id));
    }
}
