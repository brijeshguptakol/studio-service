package com.brijesh.studio.web.models;

import java.util.Date;

public record CreateBookingResponse(
        Long userId,
        String userFullName,
        Long ClassId,
        String className,
        Date bookingDate,
        Long bookingId
) {}
