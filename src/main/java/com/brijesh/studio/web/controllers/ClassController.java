package com.brijesh.studio.web.controllers;

import com.brijesh.studio.business.models.ClassDTO;
import com.brijesh.studio.business.services.ClassService;
import com.brijesh.studio.web.models.ClassVM;
import com.brijesh.studio.web.models.mappers.ClassVMMapper;
import com.brijesh.studio.web.models.mappers.CreateClassRequestMapper;
import com.brijesh.studio.web.models.CreateClassRequest;
import com.brijesh.studio.web.models.CreateClassResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RequiredArgsConstructor
@RestController
public class ClassController {

    private final ClassService classService;

    @PostMapping("/v1/classes")
    public ResponseEntity<CreateClassResponse> createClass(@RequestBody CreateClassRequest request) {

        Long Id = classService.createClass(CreateClassRequestMapper.mapToDTO(request));

        String message = String.format("Class - %s, successfully created", request.name());
        return ResponseEntity.ok(new CreateClassResponse(message));
    }

    @GetMapping("/v1/classes/{bookingId}")
    public ResponseEntity<ClassVM> getClass(@PathVariable(value = "id") Long id) {

        ClassDTO classDTO = classService.getClassById(id);

        return ResponseEntity.ok(ClassVMMapper.mapToVM(classDTO));
    }

}
