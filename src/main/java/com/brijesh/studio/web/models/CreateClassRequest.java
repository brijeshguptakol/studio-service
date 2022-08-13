package com.brijesh.studio.web.models;

import java.util.Date;

/**
 * Few bare minimum details we need to create classes are -
 * class name,
 * start_date,
 * end_date,
 * capacity.
 */
//@Getter
//@NoArgsConstructor
public record CreateClassRequest (
    String name,
    Date startDate,
    Date endDate,
    Integer maxCapacity
){}
