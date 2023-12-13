package com.nwaHospitalApi.nwaHospitalApi.Views;

import com.nwaHospitalApi.nwaHospitalApi.Entities.Employee;

import lombok.Data;

@Data
public class SurgeonView {
    
    private Integer id;

    private Integer contractID;

    private Integer surgeon_specialty;
    
    private Employee employeeInfo;

    private Integer employee_id;
}
