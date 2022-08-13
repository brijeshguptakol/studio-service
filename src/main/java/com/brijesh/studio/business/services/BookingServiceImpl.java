package com.brijesh.studio.business.services;

import com.brijesh.studio.business.exceptions.ClassNotFoundException;
import com.brijesh.studio.business.models.BookingDTO;
import com.brijesh.studio.business.models.ClassDTO;
import com.brijesh.studio.business.models.mappers.BookingDTOMapper;
import com.brijesh.studio.business.validators.BookingValidator;
import com.brijesh.studio.business.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public BookingDTO getBookingById(Long id){
        return findBookingById(id);
    }


    //DB Calls
    private Long saveBooking(BookingDTO bookingDTO){
        return bookingRepository.save(BookingDTOMapper.INSTANCE.toEntity(bookingDTO));
    }

    private BookingDTO findBookingById(Long id){
        return bookingRepository
                .findById(id)
                .map(BookingDTOMapper.INSTANCE::toDTO)
                .orElseThrow(() -> new ClassNotFoundException(id));
    }
}
