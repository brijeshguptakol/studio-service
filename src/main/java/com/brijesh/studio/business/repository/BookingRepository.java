package com.brijesh.studio.business.repository;

import com.brijesh.studio.business.repository.entities.Booking;

import java.util.Optional;

public interface BookingRepository {
    /**
     * Save the record im database
     * @param entity
     * @return
     */
    Long save(Booking entity);

    /**
     * fetch the record from database by ID.
     * @param id
     * @return
     */
    Optional<Booking> findById(Long id);
}
