package com.brijesh.studio.business.repository.entities;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @Column(nullable = false)
    private Long userId;

    private String userFullName;

    @Column(nullable = false)
    private Long classId;
    private String className;

    @Column(nullable = false)
    private Date bookingDate;

    @Column(nullable = false)
    private String createdBy;
    @Column(nullable = false)
    private Date createdWhen;

    private String updatedBy;
    private Date updatedWhen;


    public void setId(Long id){
        this.id = id;
    }
}
