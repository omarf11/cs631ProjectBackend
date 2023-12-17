package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import com.nwaHospitalApi.nwaHospitalApi.Entities.patient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PatientRepository  extends JpaRepository<patient, Integer>{

    @Modifying
    @Transactional
    @Query(value  = "UPDATE patient p SET p.primary_physician_id = :physicianId WHERE p.id = :id" , nativeQuery = true)
    void updatePhysicianId(Integer id, Integer physicianId); 
    
    @Modifying
    @Transactional
    @Query(value  = "UPDATE patient p SET p.nurse_id = :nurseId WHERE p.id = :id" , nativeQuery = true)
    void updateNurseId(Integer id, Integer nurseId);

    List<patient> findByNurseId(Integer nurseId);    
    
    List<patient> findByPrimaryPhysicianId(Integer primaryPhysicianId);    

}
