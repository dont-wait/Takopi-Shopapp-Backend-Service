package com.dontwait.shopapp.exception;

import com.dontwait.shopapp.enums.ErrorCode;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
public class AppException extends RuntimeException{
    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
