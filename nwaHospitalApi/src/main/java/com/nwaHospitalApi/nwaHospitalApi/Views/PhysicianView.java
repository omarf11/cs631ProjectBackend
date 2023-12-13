package com.nwaHospitalApi.nwaHospitalApi.Views;

import com.nwaHospitalApi.nwaHospitalApi.Entities.Employee;

import lombok.Data;

@Data
public class PhysicianView {

    private Integer id;

    private String specialty;

    private String type;

    private Integer employee_id;

    private Employee employeeInfo;
}
