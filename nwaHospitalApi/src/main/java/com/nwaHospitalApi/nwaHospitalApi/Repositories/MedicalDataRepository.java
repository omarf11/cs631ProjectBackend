package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nwaHospitalApi.nwaHospitalApi.Entities.medicalData;

public interface MedicalDataRepository extends JpaRepository<medicalData, Integer> {
    
}

