package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nwaHospitalApi.nwaHospitalApi.Entities.surgeryType;

public interface SurgeryTypeRepository extends JpaRepository<surgeryType, Integer> {
   
}

