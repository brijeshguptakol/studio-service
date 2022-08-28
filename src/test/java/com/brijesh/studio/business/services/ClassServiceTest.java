package com.brijesh.studio.business.services;

import com.brijesh.studio.business.models.ClassDTO;
import com.brijesh.studio.business.repository.ClassRepository;
import com.brijesh.studio.business.repository.entities.Class;
import com.brijesh.studio.business.validators.ClassValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClassServiceTest {

    private static final String CLASS_NAME = "Some class";
    private static final int MAX_CAPACITY =  10;
    private static final Long CLASS_ID =  1L;
    private static final Class CLASS =  Class.builder().id(CLASS_ID).build();

    private static final Date CURRENT_DATE = new Date();

    @Mock
    private ClassRepository classRepository;

    @Mock
    private ClassValidator validator;

    private ClassService service;

    @BeforeEach
    void setup(){
        service = new ClassServiceImpl(classRepository, validator);
    }

    @Test
    void save_withValidDate_returnsSavedId(){
        when(classRepository.save(any(Class.class))).thenReturn(CLASS);
        ClassDTO classDTO = createClass();
        Long classID = service.createClass(classDTO);

        assertThat(classID).isEqualTo(CLASS_ID);
    }

    @Test
    void getClassById_withValidClassId_returnsRecord(){
        Class expected = createClassEntity();
        when(classRepository.findById(CLASS_ID)).thenReturn(Optional.of(expected));
        ClassDTO actual = service.getClassById(CLASS_ID);

        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getMaxCapacity()).isEqualTo(expected.getMaxCapacity());
    }

    private ClassDTO createClass(){
        return ClassDTO
                .builder()
                .name(CLASS_NAME)
                .maxCapacity(MAX_CAPACITY)
                .startDate(CURRENT_DATE)
                .endDate(CURRENT_DATE)
                .build();
    }

    private Class createClassEntity(){
        return Class
                .builder()
                .id(CLASS_ID)
                .name(CLASS_NAME)
                .maxCapacity(MAX_CAPACITY)
                .startDate(CURRENT_DATE)
                .endDate(CURRENT_DATE)
                .build();
    }
}
