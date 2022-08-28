package com.brijesh.studio.business.services;

import com.brijesh.studio.business.models.ClassDTO;
import com.brijesh.studio.business.models.mappers.ClassDTOMapper;
import com.brijesh.studio.business.repository.entities.Class;
import com.brijesh.studio.business.validators.ClassValidator;
import com.brijesh.studio.business.exceptions.ClassNotFoundException;
import com.brijesh.studio.business.repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
class ClassServiceImpl implements ClassService{
    private final ClassRepository classRepository;
    private final ClassValidator validator;


    @Override
    public Long createClass(ClassDTO classDTO) {
        validator.validate(classDTO);
        return saveClass(classDTO);
    }

    @Override
    @Cacheable(value = "class")
    public ClassDTO getClassById(Long id) {
        return findClassById(id);
    }


    //DB Calls
    private ClassDTO findClassById(Long id){
        System.out.println("Requesting from Repository");
        return classRepository
                .findById(id)
                .map(ClassDTOMapper.INSTANCE::toDTO)
                .orElseThrow(() -> new ClassNotFoundException(id));
    }

    private Long saveClass(ClassDTO classDTO){
        Class recordToSave = ClassDTOMapper.INSTANCE.toEntity(classDTO);
        recordToSave.setCreatedBy("admin");
        recordToSave.setCreatedWhen(new Date());
        Class savedRecord =  classRepository.save(recordToSave);
        return savedRecord.getId();
    }
}
