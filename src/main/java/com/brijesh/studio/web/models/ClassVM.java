package com.brijesh.studio.web.models;

import java.util.Date;

/**
 * View model for Class information
 */
public record ClassVM (
    Long classId,
    String name,
    Date startDate,
    Date endDate,
    int maxCapacity
){}
