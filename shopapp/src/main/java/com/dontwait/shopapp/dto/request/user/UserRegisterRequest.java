package com.dontwait.shopapp.dto.request.user;

import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRegisterRequest {
    String fullName;
    @NotBlank(message = "PHONE_NUMBER_CANT_BLANK")
    @Size(min = 10, max = 11, message = "PHONE_NUMBER_MUST_BE_10_DIGIT")
    String phoneNumber;
    String address;
    @NotBlank(message = "PASSWORD_CANT_BLANK")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,}$",
            message = "PASSWORD_INVALID"
    )
    String password;
    @NotBlank(message = "RE_PASSWORD_CANT_BLANK")
    String rePassword;

    Date dateOfBirth;
    Integer facebookAccountId;
    Integer googleAccountId;
    @NotNull(message = "ROLE_CANT_NULL")
    @Min(value = 1, message = "ROLE_MUST_BE_GREATER_THAN_1")
    Long roleId;
}
