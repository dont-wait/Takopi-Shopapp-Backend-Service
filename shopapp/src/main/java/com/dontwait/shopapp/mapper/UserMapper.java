package com.dontwait.shopapp.mapper;

import com.dontwait.shopapp.dto.request.user.UserRegisterRequest;
import com.dontwait.shopapp.dto.request.user.UserUpdateRequest;
import com.dontwait.shopapp.dto.response.UserResponse;
import com.dontwait.shopapp.entity.Role;
import com.dontwait.shopapp.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target= "dateOfBirth", source = "dateOfBirth", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "userRole", source = "role.roleName")
    UserResponse toUserResponse(User user);


    User toUser(UserRegisterRequest request, Role role);

    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            ignoreByDefault = true
    )
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth", dateFormat = "yyyy-MM-dd")
    void updateUser(UserUpdateRequest request, @MappingTarget User user);
}
