package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nwaHospitalApi.nwaHospitalApi.Entities.nurse_patient;

public interface NursePatientRepository extends JpaRepository<nurse_patient, Integer> {
  
}

