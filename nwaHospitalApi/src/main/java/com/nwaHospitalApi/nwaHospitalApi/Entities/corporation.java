package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class corporation {
    
    @Id
    private Integer id;

    private String name;

    private Integer percentOwnership;

    private String headquarters;
}
