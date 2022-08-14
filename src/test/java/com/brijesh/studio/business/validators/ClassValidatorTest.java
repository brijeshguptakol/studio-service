package com.brijesh.studio.business.validators;

import com.brijesh.studio.business.exceptions.CreateClassValidationException;
import com.brijesh.studio.business.models.ClassDTO;
import com.brijesh.studio.business.utils.CurrentDateUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClassValidatorTest {
    private static final Date YESTERDAY_DATE = new Date("7/31/2022");
    private static final Date CURRENT_DATE = new Date("8/1/2022");
    private static final Date ONE_WEEK_AFTER_DATE = new Date("8/8/2022");

    @Mock
    private CurrentDateUtil currentDateUtil;

    @InjectMocks
    private ClassValidator validator;

    @Test
    void validate_withStartDateInPast_throwsValidationException() {
        when(currentDateUtil.getCurrentDate()).thenReturn(CURRENT_DATE);

        ClassDTO classDTO = createClass(YESTERDAY_DATE, ONE_WEEK_AFTER_DATE);

        CreateClassValidationException exception =  assertThrows(
                CreateClassValidationException.class,
                () -> validator.validate(classDTO)
        );

        String actualMessage = exception.getMessage();
        String expectedMessage = "Start date cannot be in past.";

        assertThat(actualMessage).isEqualTo(expectedMessage);

    }

    @Test
    void validate_withStartDateIsNull_throwsValidationException() {
        ClassDTO classDTO = createClass(null, ONE_WEEK_AFTER_DATE);

        CreateClassValidationException exception =  assertThrows(
                CreateClassValidationException.class,
                () -> validator.validate(classDTO)
        );

        String actualMessage = exception.getMessage();
        String expectedMessage = "Start date cannot be null.";

        assertThat(actualMessage).isEqualTo(expectedMessage);

    }

    @Test
    void validate_withEndDateIsNull_throwsValidationException() {
        when(currentDateUtil.getCurrentDate()).thenReturn(CURRENT_DATE);
        ClassDTO classDTO = createClass(CURRENT_DATE, null);

        CreateClassValidationException exception =  assertThrows(
                CreateClassValidationException.class,
                () -> validator.validate(classDTO)
        );

        String actualMessage = exception.getMessage();
        String expectedMessage = "End date cannot be null.";

        assertThat(actualMessage).isEqualTo(expectedMessage);

    }

    @Test
    void validate_withEndDateIsInPast_throwsValidationException() {
        when(currentDateUtil.getCurrentDate()).thenReturn(CURRENT_DATE);
        ClassDTO classDTO = createClass(CURRENT_DATE, YESTERDAY_DATE);

        CreateClassValidationException exception =  assertThrows(
                CreateClassValidationException.class,
                () -> validator.validate(classDTO)
        );

        String actualMessage = exception.getMessage();
        String expectedMessage = "End date cannot be in past.";

        assertThat(actualMessage).isEqualTo(expectedMessage);

    }

    private ClassDTO createClass(Date startDate, Date endDate){
        return ClassDTO
                .builder()
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
