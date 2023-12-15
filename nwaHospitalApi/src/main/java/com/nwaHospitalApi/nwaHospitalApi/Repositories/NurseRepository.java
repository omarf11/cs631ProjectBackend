package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nwaHospitalApi.nwaHospitalApi.Entities.nurse;

public interface NurseRepository extends JpaRepository<nurse, Integer> {
    
    Optional<nurse> findByemployeeId(Integer employee_id);
    boolean existsByemployeeId(Integer employee_id);

    @Query(value = "SELECT n.*, e.* " +
            "FROM nurse n " +
            "JOIN employee e ON n.employee_id = e.emp_id", nativeQuery = true)
    List<Object[]> findAllNurseAndEmployees();

}
