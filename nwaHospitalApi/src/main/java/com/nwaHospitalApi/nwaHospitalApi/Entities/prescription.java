package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class prescription {

    @Id
    private Integer id;

    private String dosage;
    private String duration;
    private String frequency;
    private Integer consultation_id;
}
