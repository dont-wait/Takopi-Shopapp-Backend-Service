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
    CATEGORY_NAME_CANT_NULL(1002, "Category name can't null", HttpStatus.CONFLICT),
    CATEGORY_NAME_MUST_BE_GREATER_THAN_3(1002, "Category name must be greater than 3", HttpStatus.CONFLICT),
    PRODUCT_PRICE_MUST_BE_GREATER_THAN_0(1002, "Product price must be greater than 0", HttpStatus.CONFLICT),
    PRODUCT_NAME_MUST_BE_GREATER_THAN_3(1002, "Product name must be greater than 3", HttpStatus.CONFLICT),

    FILE_TOO_LARGE(1003, "File too large! Maximun size is 10MB", HttpStatus.PAYLOAD_TOO_LARGE),
    FILE_TYPE_NOT_SUPPORTED(1003, "File must be an image", HttpStatus.UNSUPPORTED_MEDIA_TYPE),

    CATEGORY_NAME_EXISTED(1003, "Category name existed", HttpStatus.CONFLICT),

    PRODUCT_ID_NOT_FOUND(1004, "Product id not found", HttpStatus.NOT_FOUND),
    CATEGORY_ID_NOT_FOUND(1004, "Category id not found", HttpStatus.NOT_FOUND),
    UNCATEGORIZED(6789, "Uncategorized Exception", HttpStatus.INTERNAL_SERVER_ERROR);
    int code;
    String message;
    HttpStatus httpStatus;
}
