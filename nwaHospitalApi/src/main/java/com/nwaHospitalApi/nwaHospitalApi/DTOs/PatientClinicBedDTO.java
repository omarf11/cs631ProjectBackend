package com.nwaHospitalApi.nwaHospitalApi.DTOs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientClinicBedDTO {
    
    private Integer bedId;

    private String unit;
    private String wing;

    private String bedLetter;

    private Integer roomNumber;

    private Integer patientId;

    private Integer id;

    private String dob;

    private Integer ssn;

    private String bloodType;

    private String address;

    private String name;

    private String gender;

    private String admittedDate;

    private Integer duration;
    
    private Integer primaryPhysicianId;

}
