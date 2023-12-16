package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nwaHospitalApi.nwaHospitalApi.Entities.nurse;

public interface NurseRepository extends JpaRepository<nurse, Integer> {
    
    Optional<nurse> findByemployeeId(Integer employee_id);
    boolean existsByemployeeId(Integer employee_id);

    List<nurse> findBySurgeryId(Integer surgeryId);

    @Query(value = "SELECT n.*, e.* " +
            "FROM nurse n " +
            "JOIN employee e ON n.employee_id = e.emp_id", nativeQuery = true)
    List<Object[]> findAllNurseAndEmployees();


        @Modifying
    @Transactional
    @Query(value  = "UPDATE nurse p SET p.nurse_id = :nurseId WHERE p.id = :id" , nativeQuery = true)
    void updateSurgeryId(Integer id, Integer nurseId);  
}
