package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class diagnosis {
    
@Id
private Integer id;

private String comment;

private Integer consultation_id;

private Integer illness_id;

}
