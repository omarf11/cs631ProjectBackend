package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.diagnosis;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.DiagnosisRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    public List<diagnosis> getAllDiagnoses() {
        return diagnosisRepository.findAll();
    }

    public Optional<diagnosis> getDiagnosisById(Integer id) {
        return diagnosisRepository.findById(id);
    }

    public diagnosis createDiagnosis(diagnosis diagnosis) {
        return diagnosisRepository.save(diagnosis);
    }

    public diagnosis updateDiagnosis(Integer id, diagnosis updatedDiagnosis) {
        if (diagnosisRepository.existsById(id)) {
            updatedDiagnosis.setId(id);
            return diagnosisRepository.save(updatedDiagnosis);
        } else {
            throw new RuntimeException("Diagnosis with ID " + id + " not found");
        }
    }

    public void deleteDiagnosis(Integer id) {
        if (diagnosisRepository.existsById(id)) {
            diagnosisRepository.deleteById(id);
        } else {
            throw new RuntimeException("Diagnosis with ID " + id + " not found");
        }
    }
}

