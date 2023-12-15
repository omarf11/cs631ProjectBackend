package com.nwaHospitalApi.nwaHospitalApi.Views;

import com.nwaHospitalApi.nwaHospitalApi.Entities.Employee;
import com.nwaHospitalApi.nwaHospitalApi.Entities.consultation;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class PhysicianView {

    private Integer id;

    private String specialty;

    private String type;

    private Integer employee_id;

    private Employee employeeInfo;

    private List<consultation> consultations;
}
