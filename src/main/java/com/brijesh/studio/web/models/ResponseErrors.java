package com.brijesh.studio.web.models;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseErrors {

    public static ResponseEntity<ErrorResponse> createErrorResponseForBadRequest(ErrorCode errorCode, String message) {
        return new ResponseEntity<>(new ErrorResponse(errorCode, message), HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<ErrorResponse> createErrorResponseForResourceNotFound(ErrorCode errorCode, String message) {
        return new ResponseEntity<>(new ErrorResponse(errorCode, message), HttpStatus.NOT_FOUND);
    }
}
