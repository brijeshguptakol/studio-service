package com.brijesh.studio.business.repository;

import com.brijesh.studio.business.repository.entities.Class;

import java.util.Optional;

public interface ClassRepository {
    /**
     * Save the record im database
     * @param entity
     * @return
     */
    Long save(Class entity);

    /**
     * fetch the record from database by ID.
     * @param id
     * @return
     */
    Optional<Class> findById(Long id);
}
