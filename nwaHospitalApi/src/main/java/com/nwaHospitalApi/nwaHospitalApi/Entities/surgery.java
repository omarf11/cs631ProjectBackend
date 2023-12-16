package com.nwaHospitalApi.nwaHospitalApi.Entities;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;

@Builder
@Data
@Entity
@NoArgsConstructor
public class surgery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String date;

    private String theatre;

    private Integer surgeon_id;

    private Integer patient_id;

    private Integer surgery_type_id;


}
