package com.brijesh.studio.business.models.mappers;

import com.brijesh.studio.business.models.BookingDTO;
import com.brijesh.studio.business.repository.entities.Booking;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-14T01:31:01+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class BookingDTOMapperImpl implements BookingDTOMapper {

    @Override
    public BookingDTO toDTO(Booking entity) {
        if ( entity == null ) {
            return null;
        }

        BookingDTO.BookingDTOBuilder bookingDTO = BookingDTO.builder();

        bookingDTO.id( entity.getId() );
        bookingDTO.userId( entity.getUserId() );
        bookingDTO.userFullName( entity.getUserFullName() );
        bookingDTO.classId( entity.getClassId() );
        bookingDTO.className( entity.getClassName() );
        bookingDTO.bookingDate( entity.getBookingDate() );

        return bookingDTO.build();
    }

    @Override
    public Booking toEntity(BookingDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Booking.BookingBuilder booking = Booking.builder();

        if ( dto.getId() != null ) {
            booking.id( dto.getId() );
        }
        booking.userId( dto.getUserId() );
        booking.userFullName( dto.getUserFullName() );
        booking.classId( dto.getClassId() );
        booking.className( dto.getClassName() );
        booking.bookingDate( dto.getBookingDate() );

        return booking.build();
    }
}
