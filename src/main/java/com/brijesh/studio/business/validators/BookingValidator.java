package com.brijesh.studio.business.validators;

import com.brijesh.studio.business.exceptions.CreateBookingValidationException;
import com.brijesh.studio.business.exceptions.CreateClassValidationException;
import com.brijesh.studio.business.models.BookingDTO;
import com.brijesh.studio.business.models.ClassDTO;
import com.brijesh.studio.business.utils.CurrentDateUtil;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BookingValidator {
    public void validate(BookingDTO bookingDTO, ClassDTO classDTO){
        validateBookingDate(bookingDTO.getBookingDate(), classDTO.getStartDate(), classDTO.getEndDate());
    }

    private void validateBookingDate(Date bookingDate, Date classStartDate, Date classEndDate) {
        if (bookingDate == null)
            throw new CreateBookingValidationException("Booking date cannot be null.");

        if (bookingDate.before(CurrentDateUtil.getCurrentDate()))
            throw new CreateBookingValidationException("Booking date cannot be in past.");

        if (bookingDate.before(classStartDate) || bookingDate.after(classEndDate))
            throw new CreateBookingValidationException("There is no class on the requested date.");
    }
}
