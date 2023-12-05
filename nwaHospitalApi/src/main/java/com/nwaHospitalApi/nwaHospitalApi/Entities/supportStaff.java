package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class supportStaff {
    
    @Id
    private Long id;

    private String type;

    private Integer employee_id;
    
}
