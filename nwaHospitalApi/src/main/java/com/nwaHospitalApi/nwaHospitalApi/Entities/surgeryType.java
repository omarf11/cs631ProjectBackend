package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class surgeryType {
    
    @Id
    private Integer id;

    private String name;

    private String location;

    private String specialNeeds;

    private Integer surgery_skill_id;

}
