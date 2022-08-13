package com.brijesh.studio.business.models.mappers;

import com.brijesh.studio.business.models.BookingDTO;
import com.brijesh.studio.business.repository.entities.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookingDTOMapper {
    BookingDTOMapper INSTANCE = Mappers.getMapper(BookingDTOMapper.class);

    BookingDTO toDTO(Booking entity);

    Booking toEntity(BookingDTO dto);
}
