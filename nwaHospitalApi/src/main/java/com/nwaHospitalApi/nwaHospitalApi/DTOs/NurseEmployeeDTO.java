package com.nwaHospitalApi.nwaHospitalApi.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NurseEmployeeDTO {
        // Fields from Nurse entity
        private Integer id;

        private String years;
        private String shift;

        private String shift_date;

        private Integer employeeId;

        private Integer surgery_type;
        private Integer surgery_skill;

        // Fields from Employee entity
        private Integer emp_id;
        private Integer ssn;
        private String address;
        private Integer salary;
        private String name;
        private String gender;
        private Integer phonenumber;
        private String type;
}
