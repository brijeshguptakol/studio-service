package com.brijesh.studio.business.models;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

/**
 *
 */
@Value
@Builder
public class ClassDTO {
    private long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private int maxCapacity;
}
