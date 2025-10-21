package com.example.spring_assignment1.service;

import com.example.spring_assignment1.constant.CustomResponseCode;
import com.example.spring_assignment1.domain.User;
import com.example.spring_assignment1.dto.auth.UserLoginRequest;
import com.example.spring_assignment1.dto.user.UserPasswordUpdateRequest;
import com.example.spring_assignment1.dto.user.UserResponse;
import com.example.spring_assignment1.dto.user.UserSignupRequest;
import com.example.spring_assignment1.dto.user.UserNicknameUpdateRequest;
import com.example.spring_assignment1.exception.BusinessException;
import com.example.spring_assignment1.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse signup(UserSignupRequest req) {
        if (userRepository.existsByEmail(req.getEmail()))
            throw new BusinessException(CustomResponseCode.DUPLICATE_EMAIL);
        if (userRepository.existsByNickname(req.getNickname()))
            throw new BusinessException(CustomResponseCode.DUPLICATE_NICKNAME);
        User user = new User(null, req.getEmail(), req.getPassword(), req.getNickname(), req.getProfile_image());
        return toResponse(userRepository.save(user));
    }

    public UserResponse login(UserLoginRequest req) {
        User user = userRepository.findByEmail(req.getEmail()).orElseThrow(() -> new BusinessException(CustomResponseCode.USER_NOT_FOUND));
        if (!user.getPassword().equals(req.getPassword()))
            throw new BusinessException(CustomResponseCode.INVALID_PASSWORD);
        return toResponse(user);
    }

    public void logout(Long userId) {
        userRepository.findById(userId).orElseThrow(() -> new BusinessException(CustomResponseCode.USER_NOT_FOUND));
    }

    public UserResponse updateNickname(Long id, UserNicknameUpdateRequest req) {
        if (userRepository.existsByNickname(req.getNickname()))
            throw new BusinessException(CustomResponseCode.DUPLICATE_NICKNAME);
        User user = userRepository.findById(id).orElseThrow(() -> new BusinessException(CustomResponseCode.USER_NOT_FOUND));
        user.setNickname(req.getNickname());
        return toResponse(user);
    }

    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new BusinessException(CustomResponseCode.USER_NOT_FOUND));
        userRepository.delete(id);
    }

    public void updatePassword(Long id, UserPasswordUpdateRequest req) {
        User user = userRepository.findById(id).orElseThrow(() -> new BusinessException(CustomResponseCode.USER_NOT_FOUND));
        if(!user.validatePassword(req.getCurrentPassword())){
            throw new BusinessException(CustomResponseCode.INVALID_PASSWORD);
        }
        user.setPassword(req.getNewPassword());
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getEmail(), user.getNickname());
    }
}
