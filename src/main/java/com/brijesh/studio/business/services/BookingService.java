package com.brijesh.studio.business.services;

import com.brijesh.studio.business.exceptions.BookingNotFoundException;
import com.brijesh.studio.business.models.BookingDTO;

public interface BookingService {
    /**
     * Process the booking request and persist the booking in database
     * @param bookingDTO
     * @return
     */
    Long createBooking(BookingDTO bookingDTO);

    /**
     * Find a booking by a bookingId
     * @param id
     * @return
     * @throws BookingNotFoundException when the booking does not exist in the database
     */
    BookingDTO getBookingById(Long id) throws BookingNotFoundException;
}
