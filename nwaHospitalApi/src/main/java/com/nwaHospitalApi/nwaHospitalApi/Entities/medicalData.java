package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class medicalData {

    @Id
    private Integer id;

    private Integer bloodSugar;
    private Integer cholestorel;

    private Integer hol;

    private Integer triglycerides;

    private Integer ldl;

    private Integer patient_id;

    private String date;

}
