package com.brijesh.studio.web.models.mappers;

import com.brijesh.studio.business.models.BookingDTO;
import com.brijesh.studio.web.models.BookingVM;

public class BookingVMMapper {
    public static BookingVM mapToVM(BookingDTO bookingDTO){
        if(bookingDTO==null) return null;

        return  new BookingVM(
                bookingDTO.getId(),
                bookingDTO.getUserId(),
                bookingDTO.getUserFullName(),
                bookingDTO.getClassId(),
                bookingDTO.getClassName(),
                bookingDTO.getBookingDate());
    }
}
