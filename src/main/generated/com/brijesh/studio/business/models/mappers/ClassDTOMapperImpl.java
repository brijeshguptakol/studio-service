package com.brijesh.studio.business.models.mappers;

import com.brijesh.studio.business.models.ClassDTO;
import com.brijesh.studio.business.repository.entities.Class;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-14T01:31:01+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class ClassDTOMapperImpl implements ClassDTOMapper {

    @Override
    public ClassDTO toDTO(Class entity) {
        if ( entity == null ) {
            return null;
        }

        ClassDTO.ClassDTOBuilder classDTO = ClassDTO.builder();

        classDTO.id( entity.getId() );
        classDTO.name( entity.getName() );
        classDTO.startDate( entity.getStartDate() );
        classDTO.endDate( entity.getEndDate() );
        classDTO.maxCapacity( entity.getMaxCapacity() );

        return classDTO.build();
    }

    @Override
    public Class toEntity(ClassDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Class.ClassBuilder class1 = Class.builder();

        class1.id( dto.getId() );
        class1.name( dto.getName() );
        class1.startDate( dto.getStartDate() );
        class1.endDate( dto.getEndDate() );
        class1.maxCapacity( dto.getMaxCapacity() );

        return class1.build();
    }
}
