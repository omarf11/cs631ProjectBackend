package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nwaHospitalApi.nwaHospitalApi.Entities.allergy;

public interface AllergyRepository extends JpaRepository<allergy, Integer> {
   
}

