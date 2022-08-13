package com.brijesh.studio.business.repository.entities;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
//@Entity
//@Table(name = "booking")
public class Booking {

    long id;

    private final Long userId;
    private final String userFullName;
    private final Long classId;
    private final String className;
    private final Date bookingDate;

    private final String createdBy;
    private final Date createdWhen;
    private final String updatedBy;
    private final Date updatedWhen;


    public void setId(Long id){
        this.id = id;
    }
}
