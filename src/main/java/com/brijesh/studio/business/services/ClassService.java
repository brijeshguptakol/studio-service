package com.brijesh.studio.business.services;

import com.brijesh.studio.business.exceptions.ClassNotFoundException;
import com.brijesh.studio.business.exceptions.CreateClassValidationException;
import com.brijesh.studio.business.models.ClassDTO;

public interface ClassService {

    /**
     * Creates a class record and return the ID upon successful operation.
     * @param classDTO
     * @return ID of the saved record
     * @throws CreateClassValidationException when there failure due to a business validation.
     */
    Long createClass(final ClassDTO classDTO) throws CreateClassValidationException;


    /**
     * Search for the class by the given class Id
     * @param id
     * @return
     * @throws ClassNotFoundException when the class is not found.
     */
    ClassDTO getClassById(final Long id) throws ClassNotFoundException;
}
