package com.example.spring_assignment1.controller;

import com.example.spring_assignment1.constant.CustomResponseCode;
import com.example.spring_assignment1.dto.BaseResponse;
import com.example.spring_assignment1.dto.auth.UserLoginRequest;
import com.example.spring_assignment1.dto.user.UserPasswordUpdateRequest;
import com.example.spring_assignment1.dto.user.UserResponse;
import com.example.spring_assignment1.dto.user.UserSignupRequest;
import com.example.spring_assignment1.dto.user.UserNicknameUpdateRequest;
import com.example.spring_assignment1.service.UserService;
import com.example.spring_assignment1.util.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController implements UserApi {
    private UserService userService;
    //생성자가 하나라서 Autowired 자동 적용
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse<UserResponse>> signup(@Valid @RequestBody UserSignupRequest request) {
        return ResponseUtil.success(CustomResponseCode.CREATED, userService.signup(request));
    }

    @PostMapping("/auth")
    public ResponseEntity<BaseResponse<UserResponse>> login(@RequestBody UserLoginRequest request) {
        return ResponseUtil.success(userService.login(request));
    }

    @PostMapping("/auth/token")
    public ResponseEntity<BaseResponse<Void>> logout(@RequestParam Long userId) {
        userService.logout(userId);
        return ResponseUtil.success(CustomResponseCode.NO_CONTENT, null);
    }

    @PatchMapping("/{id}/nickname")
    public ResponseEntity<BaseResponse<UserResponse>> updateNickname(
            @PathVariable Long id, @RequestBody UserNicknameUpdateRequest request) {
        return ResponseUtil.success(userService.updateNickname(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseUtil.success(CustomResponseCode.NO_CONTENT, null);
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<BaseResponse<Void>> updatePassword(
            @PathVariable Long id, @RequestBody UserPasswordUpdateRequest request) {
        userService.updatePassword(id, request);
        return ResponseUtil.success(CustomResponseCode.NO_CONTENT, null);
    }

}
