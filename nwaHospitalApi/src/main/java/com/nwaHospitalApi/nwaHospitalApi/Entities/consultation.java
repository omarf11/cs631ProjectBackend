package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class consultation {

    @Id
    private Integer id;

    private String type;
    private String date;

    private String notes;
    private Integer patient_id;

    private Integer physician_id;

}
