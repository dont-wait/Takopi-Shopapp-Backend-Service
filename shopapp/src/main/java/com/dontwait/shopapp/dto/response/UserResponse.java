package com.dontwait.shopapp.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String fullName;
    String phoneNumber;
    String address;
    Date dateOfBirth;
    Integer facebookAccountId;
    Integer googleAccountId;
    Long roleId;
}
