package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class physician {
    

    @Id
    private Integer id;

    private String specialty;

    private String type;

    private Integer employeeId;
}
