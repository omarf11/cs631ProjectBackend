package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nwaHospitalApi.nwaHospitalApi.Entities.nurse;

public interface NurseRepository extends JpaRepository<nurse, Integer> {
    
}
