package com.brijesh.studio.web.models.mappers;

import com.brijesh.studio.business.models.ClassDTO;
import com.brijesh.studio.web.models.CreateClassRequest;


public class CreateClassRequestMapper {
    public static ClassDTO mapToDTO(CreateClassRequest request){
        if(request == null) return null;

        return ClassDTO
                .builder()
                .id(-1) // negative Id signifies transient entity
                .name(request.name())
                .startDate(request.startDate())
                .endDate(request.endDate())
                .maxCapacity(request.maxCapacity())
                .build();
    }
}
