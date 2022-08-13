package com.brijesh.studio.business.validators;

import com.brijesh.studio.business.exceptions.CreateClassValidationException;
import com.brijesh.studio.business.models.ClassDTO;
import com.brijesh.studio.business.utils.CurrentDateUtil;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ClassValidator {
    public void validate(ClassDTO classDTO){
        validateStartDateIsValid(classDTO.getStartDate());
        validateEndDateIsValid(classDTO.getEndDate(), classDTO.getStartDate());
    }

    private void validateStartDateIsValid(Date startDate) {
        if (startDate == null)
            throw new CreateClassValidationException("Start date cannot be null.");

        if (startDate.before(CurrentDateUtil.getCurrentDate()))
            throw new CreateClassValidationException("Start date cannot be in past.");
    }

    private void validateEndDateIsValid(Date endDate, Date startDate) {
        if (endDate == null)
            throw new CreateClassValidationException("End date cannot be null.");

        if (endDate.before(CurrentDateUtil.getCurrentDate()))
            throw new CreateClassValidationException("End date cannot be in past.");

        if (endDate.before(startDate))
            throw new CreateClassValidationException("End date should be on or after start date.");
    }
}
