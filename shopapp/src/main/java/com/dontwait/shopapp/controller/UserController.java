package com.dontwait.shopapp.controller;

import com.dontwait.shopapp.dto.request.user.UserRegisterRequest;
import com.dontwait.shopapp.dto.request.user.UserUpdateRequest;
import com.dontwait.shopapp.dto.response.ApiResponse;
import com.dontwait.shopapp.dto.response.UserResponse;
import com.dontwait.shopapp.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ApiResponse<List<UserResponse>> getUsers(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                    @RequestParam(name = "limit", defaultValue = "10") Integer limit,
                                                    @RequestParam(name = "sort", defaultValue = "fullName") String sort,
                                                    @RequestParam(name = "order", defaultValue = "asc") String order,
                                                    @RequestParam(required = false) String keyword,
                                                    @RequestParam(required = false) Integer roleId) {
        Sort.Direction direction = order.equalsIgnoreCase(("asc")) ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, limit, Sort.by(direction, sort));

        return ApiResponse.<List<UserResponse>>builder()
                .message("Get all users successfully")
                .result(userService.findAllUsers(pageable, keyword, roleId))
                .build();
    }

    @PutMapping("{userId}")
    public ApiResponse<UserResponse> updateUser(@PathVariable Long userId, @Valid @RequestBody UserUpdateRequest request) {
        return ApiResponse.<UserResponse>builder()
                .message("Update user successfully")
                .result(userService.updateUser(userId, request))
                .build();
    }

    @DeleteMapping("{userId}")
    public ApiResponse<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ApiResponse.<String>builder()
                .message("Delete user successfully")
                .build();
    }
}
