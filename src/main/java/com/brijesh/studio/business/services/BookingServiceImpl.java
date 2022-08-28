package com.brijesh.studio.business.services;

import com.brijesh.studio.business.exceptions.ClassNotFoundException;
import com.brijesh.studio.business.models.BookingDTO;
import com.brijesh.studio.business.models.ClassDTO;
import com.brijesh.studio.business.models.mappers.BookingDTOMapper;
import com.brijesh.studio.business.repository.entities.Booking;
import com.brijesh.studio.business.validators.BookingValidator;
import com.brijesh.studio.business.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ClassService classService;
    private final BookingValidator validator;

    @Override
    public Long createBooking(BookingDTO bookingDTO){
        ClassDTO classDTO = classService.getClassById(bookingDTO.getClassId());
        validator.validate(bookingDTO, classDTO);

        return saveBooking(bookingDTO);
    }

    @Override
    @Cacheable(value = "booking", key = "id")
    public BookingDTO getBookingById(Long id){
        return findBookingById(id);
    }


    //DB Calls
    private Long saveBooking(BookingDTO bookingDTO){
        Booking recordToSave = BookingDTOMapper.INSTANCE.toEntity(bookingDTO);
        recordToSave.setCreatedBy("admin");
        recordToSave.setCreatedWhen(new Date());
        Booking savedRecord =  bookingRepository.save(recordToSave);
        return savedRecord.getId();
    }

    private BookingDTO findBookingById(Long id){
        System.out.println("Requesting from Repository");
        return bookingRepository
                .findById(id)
                .map(BookingDTOMapper.INSTANCE::toDTO)
                .orElseThrow(() -> new ClassNotFoundException(id));
    }
}
