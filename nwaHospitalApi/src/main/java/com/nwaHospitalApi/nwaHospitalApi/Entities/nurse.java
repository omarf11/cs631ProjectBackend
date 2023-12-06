package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class nurse {

    @Id
    private Integer id;

    private String years;
    private String shift;

    private String shiftDate;

    private Integer employee_id;
    
    private Integer surgery_type;
    private Integer surgery_skill;

}
