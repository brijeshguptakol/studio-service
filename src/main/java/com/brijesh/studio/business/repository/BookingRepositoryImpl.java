package com.brijesh.studio.business.repository;

import com.brijesh.studio.business.utils.IdGenerator;
import com.brijesh.studio.business.repository.entities.Booking;
import lombok.Builder;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.Optional;

@Value
@Builder
@Component
public class BookingRepositoryImpl implements BookingRepository {

    private static Hashtable<Long, Booking> inMemoryStorage = new Hashtable<>();

    @Override
    public Long save(Booking entity) {
        Long id = entity.getId();

        //This is just to simulate db save and return the record with a proper ID
        if(id < 0){
            id = IdGenerator.getBookingId();
            entity.setId(id);
        }

        inMemoryStorage.put(id, entity);
        return entity.getId();
    }

    public Optional<Booking> findById(Long id){
        if(inMemoryStorage.containsKey(id))
            return Optional.of(inMemoryStorage.get(id));

        return Optional.empty();
    }
}
