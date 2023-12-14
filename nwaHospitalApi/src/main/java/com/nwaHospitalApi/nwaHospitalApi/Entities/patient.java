package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class patient {

    @Id
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
