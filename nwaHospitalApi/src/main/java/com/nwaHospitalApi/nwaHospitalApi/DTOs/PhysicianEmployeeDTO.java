package com.nwaHospitalApi.nwaHospitalApi.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhysicianEmployeeDTO {
    private Integer id;
    private String specialty;
    private String type;
    private Integer employeeId;
    private Integer empId;  // Employee details
    private Integer ssn;
    private String address;
    private Integer salary;
    private String name;
    private String gender;
    private Integer phoneNumber;
    private String employeeType;
}
