package com.brijesh.studio.web.models;

import java.util.Date;

public record CreateBookingRequest(
    Long userId,
    String userFullName,
    Long classId,
    String className,
    Date bookingDate
){}

