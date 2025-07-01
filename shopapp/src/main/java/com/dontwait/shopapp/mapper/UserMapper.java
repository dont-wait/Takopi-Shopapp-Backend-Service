package com.dontwait.shopapp.mapper;

import com.dontwait.shopapp.dto.request.user.UserRegisterRequest;
import com.dontwait.shopapp.dto.response.UserResponse;
import com.dontwait.shopapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "userRole", source = "role.roleName")
    @Mapping(target= "dateOfBirth", source = "dateOfBirth", dateFormat = "yyyy-MM-dd")
    UserResponse toUserResponse(User user);

    User toUser(UserRegisterRequest request);
}
