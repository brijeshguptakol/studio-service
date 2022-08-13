package com.brijesh.studio.business.models;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class BookingDTO {
    Long id;
    Long userId;
    String userFullName;
    Long classId;
    String className;
    Date bookingDate;
}
