package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import com.nwaHospitalApi.nwaHospitalApi.Entities.physician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicianRepository  extends JpaRepository<physician, Integer> {
    
}
