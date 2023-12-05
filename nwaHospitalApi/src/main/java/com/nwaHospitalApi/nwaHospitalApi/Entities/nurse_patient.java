package com.nwaHospitalApi.nwaHospitalApi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class nurse_patient {
    

    @Id
    private Integer idnurse_patient;

    private Integer patient_id;
    private Integer nurse_id;
    private String shift;
    private String date;
}
