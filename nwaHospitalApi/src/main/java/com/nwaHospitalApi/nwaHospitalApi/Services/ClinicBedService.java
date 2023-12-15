package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.DTOs.PatientClinicBedDTO;
import com.nwaHospitalApi.nwaHospitalApi.Entities.clinicBed;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.ClinicBedRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicBedService {

    @Autowired
    private ClinicBedRepository clinicBedRepository;

    public List<PatientClinicBedDTO> getAllClinicBeds() {
       List<Object[]> dto = clinicBedRepository.findAllClinicBedsAndPatiens();
       
        return clinicBedRepository.mapToDTO(dto);
    }

    public Optional<clinicBed> getClinicBedById(Integer bedId) {
        return clinicBedRepository.findById(bedId);
    }

    public clinicBed createClinicBed(clinicBed clinicBed) {
        return clinicBedRepository.save(clinicBed);
    }

    public clinicBed updateClinicBed(Integer bedId, clinicBed updatedClinicBed) {
        if (clinicBedRepository.existsById(bedId)) {
            updatedClinicBed.setBedId(bedId);
            return clinicBedRepository.save(updatedClinicBed);
        } else {
            throw new RuntimeException("ClinicBed with ID " + bedId + " not found");
        }
    }
     public clinicBed updateClinicBedPatient(Integer bedId, Integer patientId) {
        if (clinicBedRepository.existsById(bedId)) {
            clinicBedRepository.updatePatientIdByBedId(bedId , patientId);
            return clinicBedRepository.findById(bedId).get();
        } else {
            throw new RuntimeException("ClinicBed with ID " + bedId + " not found");
        }
    }

    public void removePatient(Integer bedId) {
        if (clinicBedRepository.existsById(bedId)) {
            clinicBedRepository.updatePatientIdToNullByBedId(bedId);
        } else {
            throw new RuntimeException("ClinicBed with ID " + bedId + " not found");
        }
    }

}
