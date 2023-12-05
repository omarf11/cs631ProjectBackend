package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class medicine {

    @Id
    private Integer id;

    private Integer unitCose;
    private Integer quantityOrdered;

    private String usage;

    private String name;

    private String quantity;

    private String severity;

    private Integer corporation_id;

}
