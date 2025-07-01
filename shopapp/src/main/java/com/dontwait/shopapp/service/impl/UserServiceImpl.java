package com.dontwait.shopapp.service.impl;

import com.dontwait.shopapp.dto.request.user.UserRegisterRequest;
import com.dontwait.shopapp.dto.request.user.UserUpdateRequest;
import com.dontwait.shopapp.dto.response.UserResponse;
import com.dontwait.shopapp.entity.Role;
import com.dontwait.shopapp.entity.User;
import com.dontwait.shopapp.enums.ErrorCode;
import com.dontwait.shopapp.exception.AppException;
import com.dontwait.shopapp.mapper.UserMapper;
import com.dontwait.shopapp.repository.RoleRepository;
import com.dontwait.shopapp.repository.UserRepository;
import com.dontwait.shopapp.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    UserMapper userMapper;
    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserRegisterRequest request) {
        if(userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new AppException(ErrorCode.PHONE_NUMBER_EXISTED);
        }
        //Check role
        Role role = roleRepository.findByRoleId(request.getRoleId()).
                orElseThrow(() -> new AppException(ErrorCode.ROLE_ID_NOT_FOUND));

        User user = userMapper.toUser(request, role);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponse> findAllUsers(Pageable pageable, String keyword, Integer roleId) {
        Specification<User> spec = Specification.where(null);
        if(roleId != null) {
            spec = spec.and((root, query, cb)
        -> cb.equal(root.get("role").get("roleId"), roleId));
        }
        if(keyword != null && !keyword.isEmpty()) {
            spec = spec.and((root, query, cb) -> cb.like(root.get("fullName"), "%" + keyword + "%"));
        }

        return userRepository.findAll(spec, pageable).stream()
                .map(userMapper::toUserResponse)
                .toList();
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
