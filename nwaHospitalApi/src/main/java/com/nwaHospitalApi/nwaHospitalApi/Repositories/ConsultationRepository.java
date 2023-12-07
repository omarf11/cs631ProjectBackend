package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nwaHospitalApi.nwaHospitalApi.Entities.consultation;

public interface ConsultationRepository extends JpaRepository<consultation, Integer> {
}

