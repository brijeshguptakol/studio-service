package com.brijesh.studio.web.controllers;

import com.brijesh.studio.business.exceptions.BookingNotFoundException;
import com.brijesh.studio.business.exceptions.CreateBookingValidationException;
import com.brijesh.studio.business.exceptions.CreateClassValidationException;
import com.brijesh.studio.business.exceptions.ClassNotFoundException;
import com.brijesh.studio.web.models.ErrorCode;
import com.brijesh.studio.web.models.ErrorResponse;
import com.brijesh.studio.web.models.ResponseErrors;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ErrorHandlers {

    @ExceptionHandler({CreateClassValidationException.class, CreateBookingValidationException.class})
    public ResponseEntity<ErrorResponse> handleFailedValidations(Exception ex, WebRequest request) {
        return ResponseErrors.createErrorResponseForBadRequest(ErrorCode.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler({ClassNotFoundException.class, BookingNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleClassNotFoundException(Exception ex, WebRequest request) {
        return ResponseErrors.createErrorResponseForResourceNotFound(ErrorCode.NOT_FOUND, ex.getMessage());
    }
}
