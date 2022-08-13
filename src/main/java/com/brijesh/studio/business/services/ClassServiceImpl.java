package com.brijesh.studio.business.services;

import com.brijesh.studio.business.models.ClassDTO;
import com.brijesh.studio.business.models.mappers.ClassDTOMapper;
import com.brijesh.studio.business.validators.ClassValidator;
import com.brijesh.studio.business.exceptions.ClassNotFoundException;
import com.brijesh.studio.business.repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public ClassDTO getClassById(Long id) {
        return findClassById(id);
    }


    //DB Calls
    private ClassDTO findClassById(Long id){
        return classRepository
                .findById(id)
                .map(ClassDTOMapper.INSTANCE::toDTO)
                .orElseThrow(() -> new ClassNotFoundException(id));
    }

    private Long saveClass(ClassDTO classDTO){
        return classRepository.save(ClassDTOMapper.INSTANCE.toEntity(classDTO));
    }
}
