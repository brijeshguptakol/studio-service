package com.brijesh.studio.web.models;

import java.util.Date;

public record BookingVM(
    Long bookingId,
    Long userId,
    String userFullName,
    Long classId,
    String className,
    Date bookingDate
    ){}
