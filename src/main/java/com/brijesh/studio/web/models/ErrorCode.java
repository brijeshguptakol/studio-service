package com.brijesh.studio.web.models;

public enum ErrorCode {
    BAD_REQUEST(1),
    NOT_FOUND(2);
    
    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }
}