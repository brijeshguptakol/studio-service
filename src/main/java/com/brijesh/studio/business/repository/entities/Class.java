package com.brijesh.studio.business.repository.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "classes")
public class Class {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private int maxCapacity;

    @Column(nullable = false)
    private String createdBy;
    @Column(nullable = false)
    private Date createdWhen;

    private String updatedBy;
    private Date updatedWhen;


//    public void setId(Long id){
//        this.id = id;
//    }
}
