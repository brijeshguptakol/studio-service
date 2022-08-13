package com.brijesh.studio.web.models;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ErrorResponse {

    private final ErrorCode errorCode;
    private final String errorMessage;
}
