package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import com.nwaHospitalApi.nwaHospitalApi.Entities.patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository  extends JpaRepository<patient, Integer>{
    
}
