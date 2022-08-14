package com.brijesh.studio.business.validators;

import com.brijesh.studio.business.exceptions.CreateBookingValidationException;
import com.brijesh.studio.business.models.BookingDTO;
import com.brijesh.studio.business.models.ClassDTO;
import com.brijesh.studio.business.utils.CurrentDateUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingValidatorTest {

    private static final Date YESTERDAY_DATE = new Date("7/31/2022");
    private static final Date CURRENT_DATE = new Date("8/1/2022");
    private static final Date ONE_WEEK_AFTER_DATE = new Date("8/8/2022");

    @Mock
    private CurrentDateUtil currentDateUtil;

    @InjectMocks
    private BookingValidator validator;

    @Test
    void validate_withBookingDateIsNull_throwsValidationException() {

        ClassDTO classDTO = createClass(YESTERDAY_DATE, ONE_WEEK_AFTER_DATE);
        BookingDTO booking = createBooking(null);

        CreateBookingValidationException exception =  assertThrows(
                CreateBookingValidationException.class,
                () -> validator.validate(booking, classDTO)
        );

        String actualMessage = exception.getMessage();
        String expectedMessage = "Booking date cannot be null.";

        assertThat(actualMessage).isEqualTo(expectedMessage);

    }

    @Test
    void validate_withBookingDateIsInPast_throwsValidationException() {
        when(currentDateUtil.getCurrentDate()).thenReturn(CURRENT_DATE);

        ClassDTO classDTO = createClass(YESTERDAY_DATE, ONE_WEEK_AFTER_DATE);
        BookingDTO booking = createBooking(YESTERDAY_DATE);

        CreateBookingValidationException exception =  assertThrows(
                CreateBookingValidationException.class,
                () -> validator.validate(booking, classDTO)
        );

        String actualMessage = exception.getMessage();
        String expectedMessage = "Booking date cannot be in past.";

        assertThat(actualMessage).isEqualTo(expectedMessage);

    }

    @Test
    void validate_withBookingDateIsNotAvailable_throwsValidationException() {
        when(currentDateUtil.getCurrentDate()).thenReturn(CURRENT_DATE);

        ClassDTO classDTO = createClass(YESTERDAY_DATE, CURRENT_DATE);
        BookingDTO booking = createBooking(ONE_WEEK_AFTER_DATE);

        CreateBookingValidationException exception =  assertThrows(
                CreateBookingValidationException.class,
                () -> validator.validate(booking, classDTO)
        );

        String actualMessage = exception.getMessage();
        String expectedMessage = "There is no class on the requested date.";

        assertThat(actualMessage).isEqualTo(expectedMessage);

    }

    private BookingDTO createBooking(Date bookingDate){
        return BookingDTO
                .builder()
                .bookingDate(bookingDate)
                .build();
    }

    private ClassDTO createClass(Date startDate, Date endDate){
        return ClassDTO
                .builder()
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
