package com.brijesh.studio.business.exceptions;

public class BookingNotFoundException extends RuntimeException {

    public BookingNotFoundException(Long id) {
        super(String.format("Booking with Id - {%s}, was not found", id));
    }
}
