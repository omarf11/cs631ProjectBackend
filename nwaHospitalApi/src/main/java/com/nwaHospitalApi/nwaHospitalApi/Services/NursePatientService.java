package com.nwaHospitalApi.nwaHospitalApi.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.nurse_patient;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.NursePatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NursePatientService {

    @Autowired
    private NursePatientRepository nursePatientRepository;

    public List<nurse_patient> getAllNursePatients() {
        return nursePatientRepository.findAll();
    }

    public Optional<nurse_patient> getNursePatientById(Integer id) {
        return nursePatientRepository.findById(id);
    }

    public nurse_patient createNursePatient(nurse_patient nursePatient) {
        return nursePatientRepository.save(nursePatient);
    }

    public nurse_patient updateNursePatient(Integer id, nurse_patient updatedNursePatient) {
        if (nursePatientRepository.existsById(id)) {
            updatedNursePatient.setIdnurse_patient(id);
            return nursePatientRepository.save(updatedNursePatient);
        } else {
            throw new RuntimeException("NursePatient with ID " + id + " not found");
        }
    }

    public void deleteNursePatient(Integer id) {
        if (nursePatientRepository.existsById(id)) {
            nursePatientRepository.deleteById(id);
        } else {
            throw new RuntimeException("NursePatient with ID " + id + " not found");
        }
    }
}

