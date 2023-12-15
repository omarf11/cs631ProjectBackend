package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class clinicBed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bedId;

    private String unit;
    private String wing;

    private String bedLetter;

    private Integer roomNumber;
    private Integer patientId;

}
