package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee" , schema = "nwaHospital" )
public class Employee {
    
    @Id
    private Integer emp_id;

    private Integer ssn;

    private String address;

    private Integer salary;

    private String name;

    private String gender;

    private Integer phonenumber;

    private String type; 

}
