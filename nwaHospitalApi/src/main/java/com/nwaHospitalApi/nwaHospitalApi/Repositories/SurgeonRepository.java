package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import com.nwaHospitalApi.nwaHospitalApi.Entities.surgeon;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SurgeonRepository extends JpaRepository<surgeon, Integer> {
    
}
