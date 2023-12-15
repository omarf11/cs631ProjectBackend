package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nwaHospitalApi.nwaHospitalApi.Entities.consultation;

public interface ConsultationRepository extends JpaRepository<consultation, Integer> {

    List<consultation> findByphysicianId(Integer physician_Id);
}

