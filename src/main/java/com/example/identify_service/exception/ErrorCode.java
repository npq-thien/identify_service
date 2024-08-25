package com.example.identify_service.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public enum ErrorCode {
    USER_EXISTED(1001, "User exists"),
    USER_NOT_EXISTED(1002, "User not exists");
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
