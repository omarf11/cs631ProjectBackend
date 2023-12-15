package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import com.nwaHospitalApi.nwaHospitalApi.DTOs.PhysicianEmployeeDTO;
import com.nwaHospitalApi.nwaHospitalApi.Entities.physician;

import java.util.Optional;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhysicianRepository  extends JpaRepository<physician, Integer> {

    Optional<physician> findByemployeeId(Integer employee_id);
    boolean existsByemployeeId(Integer employee_id);
    


    @Query(value = "SELECT p.*, e.* " +
    "FROM physician p " +
    "JOIN employee e ON p.employee_id = e.emp_id" , nativeQuery = true)
List<Object[]> findAllPhysicianAndEmployees();


    default List<PhysicianEmployeeDTO> mapToDTO(List<Object[]> results) {
        return results.stream()
                .map(result -> PhysicianEmployeeDTO.builder()
                    .id((Integer) result[0])
                    .specialty((String) result[1])
                    .type((String) result[2])
                    .employeeId((Integer) result[3])
                    .empId((Integer) result[4])
                    .ssn((Integer) result[5])
                    .address((String) result[6])
                    .salary((Integer) result[7])
                    .name((String) result[8])
                    .gender((String) result[9])
                    .phoneNumber((Integer) result[10])
                    .employeeType((String) result[11])
                    .build())
                .collect(Collectors.toList());
    }

}
