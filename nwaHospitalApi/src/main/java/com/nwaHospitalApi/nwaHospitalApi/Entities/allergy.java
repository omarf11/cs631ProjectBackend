package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class allergy {
    
    @Id
    private Integer allergyId;

    private String allergyDescription;

    private Integer patient_id;
}
