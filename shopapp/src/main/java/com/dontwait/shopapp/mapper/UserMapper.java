package com.dontwait.shopapp.mapper;

import com.dontwait.shopapp.dto.request.user.UserRegisterRequest;
import com.dontwait.shopapp.dto.response.UserResponse;
import com.dontwait.shopapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "userRole", source = "role.roleName")
    UserResponse toUserResponse(User user);

    User toUser(UserRegisterRequest request);
}
