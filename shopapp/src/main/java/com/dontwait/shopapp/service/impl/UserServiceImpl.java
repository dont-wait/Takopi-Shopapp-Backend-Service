package com.dontwait.shopapp.service.impl;

import com.dontwait.shopapp.dto.request.user.UserRegisterRequest;
import com.dontwait.shopapp.dto.response.UserResponse;
import com.dontwait.shopapp.mapper.UserMapper;
import com.dontwait.shopapp.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    UserMapper userMapper;

    @Override
    public UserResponse createUser(UserRegisterRequest request) {
        return userMapper.toUserResponse(userMapper.toUser(request));
    }
}
