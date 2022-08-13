package com.brijesh.studio.web.models.mappers;

import com.brijesh.studio.business.models.ClassDTO;
import com.brijesh.studio.web.models.ClassVM;

public class ClassVMMapper {
    public static ClassVM mapToVM(ClassDTO classDTO) {
        if (classDTO == null) return null;

        return new ClassVM(
                classDTO.getId(),
                classDTO.getName(),
                classDTO.getStartDate(),
                classDTO.getEndDate(),
                classDTO.getMaxCapacity()
        );
    }
}
