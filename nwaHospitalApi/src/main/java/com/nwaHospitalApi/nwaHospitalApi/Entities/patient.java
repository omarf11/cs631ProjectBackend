package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dob;

    private Integer ssn;

    private String bloodType;

    private String address;

    private String name;

    private String gender;

    private Integer bed_id;

    private String admittedDate;

    private Integer duration;
    
    private Integer primaryPhysicianId;

}
