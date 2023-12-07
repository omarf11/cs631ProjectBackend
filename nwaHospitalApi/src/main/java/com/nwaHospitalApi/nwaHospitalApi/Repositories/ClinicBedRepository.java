package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nwaHospitalApi.nwaHospitalApi.Entities.clinicBed;

public interface ClinicBedRepository extends JpaRepository<clinicBed, Integer> {
    
}

