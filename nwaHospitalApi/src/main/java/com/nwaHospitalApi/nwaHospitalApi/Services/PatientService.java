package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.patient;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<patient> getPatientById(Integer id) {
        return patientRepository.findById(id);
    }

    public patient createPatient(patient patient) {
        return patientRepository.save(patient);
    }

    public List<patient> getPatientsByNurseId (Integer nurseId) {
        return patientRepository.findByNurseId(nurseId);
    }
    public List<patient> getPatientsByPhysicianId (Integer physicianId) {
        return patientRepository.findByPrimaryPhysicianId(physicianId);
    }

    public patient updatePatient(Integer id, patient updatedPatient) {
        if (patientRepository.existsById(id)) {
            updatedPatient.setId(id);
            return patientRepository.save(updatedPatient);
        } else {
            throw new RuntimeException("Patient with ID " + id + " not found");
        }
    }

    public void deletePatient(Integer id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
        } else {
            throw new RuntimeException("Patient with ID " + id + " not found");
        }
    }

    public patient updatePatientPhysId(Integer id,  Integer physicianId) {

        if (patientRepository.existsById(id)) {
            patientRepository.updatePhysicianId(id, physicianId);
            
            return patientRepository.findById(id).get();
        } else {
            throw new RuntimeException("NOT FOUND");
        }
    }

    public patient updatePatientNurseId(Integer id, Integer nurseId) {
        if (patientRepository.existsById(id)) {
            patientRepository.updateNurseId(id, nurseId);

            return patientRepository.findById(id).get();
        } else {
            throw new RuntimeException("NOT FOUND");
        }
    }
}
