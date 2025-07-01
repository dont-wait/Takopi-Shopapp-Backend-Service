package com.dontwait.shopapp.service;

import com.dontwait.shopapp.dto.request.user.UserRegisterRequest;
import com.dontwait.shopapp.dto.request.user.UserUpdateRequest;
import com.dontwait.shopapp.dto.response.UserResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRegisterRequest request);
    List<UserResponse> findAllUsers(Pageable pageable, String keyword, Integer roleId);
    UserResponse findUserById(Integer userId);
    void deleteUser(Integer userId);
    UserResponse updateUser(Integer userId, UserUpdateRequest request);
}
