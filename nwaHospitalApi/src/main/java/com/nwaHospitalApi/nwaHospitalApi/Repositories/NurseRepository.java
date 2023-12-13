package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nwaHospitalApi.nwaHospitalApi.Entities.nurse;

public interface NurseRepository extends JpaRepository<nurse, Integer> {
    
    Optional<nurse> findByemployeeId(Integer employee_id);
    boolean existsByemployeeId(Integer employee_id);

}
