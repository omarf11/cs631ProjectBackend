package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class surgeon {
    
    @Id
    private Long id;

    private Integer contractID;

    private Integer surgeon_specialty;
}
