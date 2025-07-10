package com.dontwait.shopapp.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    INVALID_ID_KEY(1001, "Invalid Message key, you should check your key", HttpStatus.BAD_REQUEST), //Sai sot trong dat viec dat Message tai DTO
    CATEGORY_NAME_CANT_NULL(1002, "Category name can't null", HttpStatus.BAD_REQUEST),
    CATEGORY_NAME_MUST_BE_GREATER_THAN_3(1002, "Category name must be greater than 3", HttpStatus.CONFLICT),
    PRODUCT_PRICE_MUST_BE_GREATER_THAN_0(1002, "Product price must be greater than 0", HttpStatus.CONFLICT),
    PRODUCT_NAME_MUST_BE_GREATER_THAN_3(1002, "Product name must be greater than 3", HttpStatus.CONFLICT),
    PHONE_NUMBER_EXISTED(1002, "Phone number existed", HttpStatus.CONFLICT),

    PHONE_NUMBER_CANT_BLANK(1002, "Phone number can't blank", HttpStatus.BAD_REQUEST),
    PHONE_NUMBER_MUST_BE_10_DIGIT(1002, "Phone number must be 10 digit", HttpStatus.BAD_REQUEST),
    EMAIL_INVALID(1002, "Email is invalid", HttpStatus.BAD_REQUEST),
    PASSWORD_CANT_BLANK(1002, "Password Cant blank", HttpStatus.BAD_REQUEST),
    RE_PASSWORD_CANT_BLANK(1002, "RePassword Cant blank", HttpStatus.BAD_REQUEST),
    ROLE_CANT_NULL(1002, "Role can't null", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1002, "Password must be include 0-9 characters, number and specific character(s)", HttpStatus.BAD_REQUEST),
    RE_PASSWORD_NOT_MATCH(1002, "Password and re-password must be same", HttpStatus.BAD_REQUEST),

    FILE_TOO_LARGE(1003, "File too large! Maximum size is 10MB", HttpStatus.PAYLOAD_TOO_LARGE),
    FILE_TYPE_NOT_SUPPORTED(1003, "File must be an image", HttpStatus.UNSUPPORTED_MEDIA_TYPE),

    CATEGORY_NAME_EXISTED(1003, "Category name existed", HttpStatus.CONFLICT),

    PRODUCT_ID_NOT_FOUND(1004, "Product id not found", HttpStatus.NOT_FOUND),
    CATEGORY_ID_NOT_FOUND(1004, "Category id not found", HttpStatus.NOT_FOUND),
    ROLE_ID_NOT_FOUND(1004, "Role id not found", HttpStatus.NOT_FOUND),
    UNCATEGORIZED(6789, "Uncategorized Exception", HttpStatus.INTERNAL_SERVER_ERROR);
    int code;
    String message;
    HttpStatus httpStatus;
}
