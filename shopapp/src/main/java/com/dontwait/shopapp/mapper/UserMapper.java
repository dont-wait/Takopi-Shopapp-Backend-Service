package com.dontwait.shopapp.mapper;

import com.dontwait.shopapp.dto.request.user.UserRegisterRequest;
import com.dontwait.shopapp.dto.response.UserResponse;
import com.dontwait.shopapp.entity.Role;
import com.dontwait.shopapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target= "dateOfBirth", source = "dateOfBirth", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "userRole", source = "role.roleName")
    UserResponse toUserResponse(User user);

    User toUser(UserRegisterRequest request, Role role);
}
