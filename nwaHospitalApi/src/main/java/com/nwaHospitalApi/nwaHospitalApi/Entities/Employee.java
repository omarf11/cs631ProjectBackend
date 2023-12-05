package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {
    
    @Id
    private Long empId;

    private Integer ssn;

    private String address;

    private Integer salary;

    private String name;

    private String gender;

    private Integer phoneNumber;

    private String type; 

}
