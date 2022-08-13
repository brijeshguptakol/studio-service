package com.brijesh.studio.business.models.mappers;

import com.brijesh.studio.business.models.ClassDTO;
import com.brijesh.studio.business.repository.entities.Class;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClassDTOMapper {
    ClassDTOMapper INSTANCE = Mappers.getMapper(ClassDTOMapper.class);

    ClassDTO toDTO(Class entity);

    Class toEntity(ClassDTO dto);
}
