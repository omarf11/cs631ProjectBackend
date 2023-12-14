package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import com.nwaHospitalApi.nwaHospitalApi.Entities.physician;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicianRepository  extends JpaRepository<physician, Integer> {

    Optional<physician> findByemployeeId(Integer employee_id);
    boolean existsByemployeeId(Integer employee_id);
    
}
