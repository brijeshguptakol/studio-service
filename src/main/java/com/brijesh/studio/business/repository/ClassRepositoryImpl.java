package com.brijesh.studio.business.repository;

import com.brijesh.studio.business.utils.IdGenerator;
import com.brijesh.studio.business.repository.entities.Class;
import lombok.Builder;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.Optional;

@Value
@Builder
@Component
public class ClassRepositoryImpl implements ClassRepository {

    private static Hashtable<Long, Class> inMemoryStorage = new Hashtable<>();

    @Override
    public Long save(Class entity) {
        Long id = entity.getId();

        //This is just to simulate db save and return the record with a proper ID
        if(id < 0){
            id = IdGenerator.getClassId();
            entity.setId(id);
        }

        inMemoryStorage.put(id, entity);
        return entity.getId();
    }

    public Optional<Class> findById(Long id){
        if(inMemoryStorage.containsKey(id))
            return Optional.of(inMemoryStorage.get(id));

        return Optional.empty();
    }
}
