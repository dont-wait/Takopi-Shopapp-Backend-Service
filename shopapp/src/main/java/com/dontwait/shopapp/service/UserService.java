package com.dontwait.shopapp.service;

import com.dontwait.shopapp.dto.request.user.UserRegisterRequest;
import com.dontwait.shopapp.dto.response.UserResponse;

public interface UserService {
    UserResponse createUser(UserRegisterRequest request);
}
