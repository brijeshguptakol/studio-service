package com.brijesh.studio.business.repository;

import com.brijesh.studio.business.repository.entities.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface BookingRepository extends CrudRepository<Booking, Long> { }
