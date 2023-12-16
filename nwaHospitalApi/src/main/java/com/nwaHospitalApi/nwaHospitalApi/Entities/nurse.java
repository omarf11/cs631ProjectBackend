package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String years;
    private String shift;

    private String shift_date;

    private Integer employeeId;
    
    private Integer surgery_type;
    private Integer surgery_skill;
    private Integer surgeryId;

}
