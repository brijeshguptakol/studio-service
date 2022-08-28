package com.brijesh.studio.business.repository;

import com.brijesh.studio.business.repository.entities.Class;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ClassRepository extends CrudRepository<Class, Long> { }
