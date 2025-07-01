package com.dontwait.shopapp.controller;

import com.dontwait.shopapp.dto.request.user.UserRegisterRequest;
import com.dontwait.shopapp.dto.response.ApiResponse;
import com.dontwait.shopapp.dto.response.UserResponse;
import com.dontwait.shopapp.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @PostMapping("/register")
    public ApiResponse<UserResponse> createUser(@Valid @RequestBody UserRegisterRequest request) {
        return ApiResponse.<UserResponse>builder()
                .message("Create user successfully")
                .result(userService.createUser(request))
                .build();
    }
}
