package com.dontwait.shopapp.service.impl;

import com.dontwait.shopapp.dto.request.user.UserRegisterRequest;
import com.dontwait.shopapp.dto.request.user.UserUpdateRequest;
import com.dontwait.shopapp.dto.response.UserResponse;
import com.dontwait.shopapp.mapper.UserMapper;
import com.dontwait.shopapp.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    UserMapper userMapper;

    @Override
    public UserResponse createUser(UserRegisterRequest request) {
        return userMapper.toUserResponse(userMapper.toUser(request));
    }

    @Override
    public List<UserResponse> findAllUsers(Pageable pageable, String keyword, Integer roleId) {
        return List.of();
    }

    @Override
    public UserResponse findUserById(Integer userId) {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public UserResponse updateUser(Integer userId, UserUpdateRequest request) {
        return null;
    }
}
