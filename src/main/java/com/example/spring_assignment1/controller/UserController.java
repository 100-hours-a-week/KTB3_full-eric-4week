package com.example.spring_assignment1.controller;

import com.example.spring_assignment1.constant.CustomResponseCode;
import com.example.spring_assignment1.dto.ApiResponse;
import com.example.spring_assignment1.dto.auth.UserLoginRequest;
import com.example.spring_assignment1.dto.user.UserResponse;
import com.example.spring_assignment1.dto.user.UserSignupRequest;
import com.example.spring_assignment1.dto.user.UserUpdateRequest;
import com.example.spring_assignment1.service.UserService;
import com.example.spring_assignment1.util.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    //생성자가 하나라서 Autowired 자동 적용
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> signup(@Valid @RequestBody UserSignupRequest request) {
        return ResponseUtil.success(CustomResponseCode.CREATED, userService.signup(request));
    }

    @PostMapping("/auth")
    public ResponseEntity<ApiResponse<UserResponse>> login(@RequestBody UserLoginRequest request) {
        System.out.println(request.getEmail());
        return ResponseUtil.success(userService.login(request));
    }

    @PostMapping("/auth/token")
    public ResponseEntity<ApiResponse<Void>> logout(@RequestParam Long userId) {
        userService.logout(userId);
        return ResponseUtil.success(CustomResponseCode.NO_CONTENT, null);
    }


    @PatchMapping("/{id}/nickname")
    public ResponseEntity<ApiResponse<UserResponse>> updateNickname(
            @PathVariable Long id, @RequestBody UserUpdateRequest request) {
        return ResponseUtil.success(userService.updateNickname(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseUtil.success(CustomResponseCode.NO_CONTENT, null);
    }

    @PostMapping("/validate-password")
    public ResponseEntity<ApiResponse<Boolean>> validatePassword(
            @RequestParam Long id, @RequestParam String password) {
        return ResponseUtil.success(userService.validatePassword(id, password));
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<ApiResponse<Void>> updatePassword(
            @PathVariable Long id, @RequestParam String newPassword) {
        userService.updatePassword(id, newPassword);
        return ResponseUtil.success(CustomResponseCode.NO_CONTENT, null);
    }

}
