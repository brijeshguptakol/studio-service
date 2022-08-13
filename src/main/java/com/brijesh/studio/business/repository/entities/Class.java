package com.brijesh.studio.business.repository.entities;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
//@Entity
//@Table(name = "class")
public class Class {

    long id;

    private final String name;
    private final Date startDate;
    private final Date endDate;
    private final int maxCapacity;

    private final String createdBy;
    private final Date createdWhen;
    private final String updatedBy;
    private final Date updatedWhen;


    public void setId(Long id){
        this.id = id;
    }
}
