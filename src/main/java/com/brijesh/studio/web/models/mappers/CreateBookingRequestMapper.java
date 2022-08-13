package com.brijesh.studio.web.models.mappers;

import com.brijesh.studio.business.models.BookingDTO;
import com.brijesh.studio.web.models.CreateBookingRequest;

public class CreateBookingRequestMapper {
    public static BookingDTO mapToDTO(CreateBookingRequest request){
        if(request == null) return null;

        return BookingDTO
                .builder()
                .id(-1L) // negative Id signifies transient entity
                .userId(request.userId())
                .userFullName(request.userFullName())
                .classId(request.classId())
                .className(request.className())
                .bookingDate(request.bookingDate())
                .build();
    }
}
