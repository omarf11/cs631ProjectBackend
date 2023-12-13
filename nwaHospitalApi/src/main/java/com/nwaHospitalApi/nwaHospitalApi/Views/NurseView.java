package com.nwaHospitalApi.nwaHospitalApi.Views;

import com.nwaHospitalApi.nwaHospitalApi.Entities.Employee;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NurseView {

    private Integer id;

    private String years;

    private String shift;

    private String shiftDate;

    private Integer employee_id;
    
    private Integer surgery_type;

    private Integer surgery_skill;

    private Employee employeeInfo;
}
