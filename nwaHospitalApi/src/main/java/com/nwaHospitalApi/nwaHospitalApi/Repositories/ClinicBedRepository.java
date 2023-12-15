package com.nwaHospitalApi.nwaHospitalApi.Repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nwaHospitalApi.nwaHospitalApi.DTOs.PatientClinicBedDTO;
import com.nwaHospitalApi.nwaHospitalApi.DTOs.PhysicianEmployeeDTO;
import com.nwaHospitalApi.nwaHospitalApi.Entities.clinicBed;

public interface ClinicBedRepository extends JpaRepository<clinicBed, Integer> {

    @Query(value = "SELECT c.*, p.* " +
            "FROM clinic_bed c " +
            "LEFT JOIN patient p ON c.patient_id = p.id", nativeQuery = true)
    List<Object[]> findAllClinicBedsAndPatiens();

        default List<PatientClinicBedDTO> mapToDTO(List<Object[]> results) {
        return results.stream()
                .map(result -> PatientClinicBedDTO.builder()
                .bedId((Integer) result[0])
                .unit((String) result[1])
                .wing((String) result[2])
                .bedLetter((String) result[3])
                .roomNumber((Integer) result[4])
                .patientId((Integer) result[5])
                .id((Integer) result[6])
                .dob((String) result[7])
                .ssn((Integer) result[8])
                .bloodType((String) result[9])
                .address((String) result[10])
                .name((String) result[11])
                .gender((String) result[12])
                .admittedDate((String) result[13])
                .duration((Integer) result[14])
                .primaryPhysicianId((Integer) result[15])
                    .build())
                .collect(Collectors.toList());
    }
    
}

