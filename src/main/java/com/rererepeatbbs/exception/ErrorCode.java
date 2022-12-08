package com.rererepeatbbs.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorCode {
    DUPLICATED_USER_NAME(HttpStatus.CONFLICT, "User name is duplicated"),
    NOT_FOUNDED(HttpStatus.NOT_FOUND, "Not Found"),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST,""),
    USER_NOT_FOUNDED(HttpStatus.NOT_FOUND, "User Not Found");


    private HttpStatus status;
    private String message;
}
