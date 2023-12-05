package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class surgery {

    @Id
    private Long id;

    private String date;

    private String theatre;

    private Integer surgeon_id;

    private Integer patient_id;

    private Integer surgery_type_id;

}
