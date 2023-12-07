package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nwaHospitalApi.nwaHospitalApi.Entities.surgerySkill;

public interface SurgerySkillRepository extends JpaRepository<surgerySkill, Integer> {
    
}

