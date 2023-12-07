package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.medicalData;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.MedicalDataRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalDataService {

    @Autowired
    private MedicalDataRepository medicalDataRepository;

    public List<medicalData> getAllMedicalData() {
        return medicalDataRepository.findAll();
    }

    public Optional<medicalData> getMedicalDataById(Integer id) {
        return medicalDataRepository.findById(id);
    }

    public medicalData createMedicalData(medicalData medicalData) {
        return medicalDataRepository.save(medicalData);
    }

    public medicalData updateMedicalData(Integer id, medicalData updatedMedicalData) {
        if (medicalDataRepository.existsById(id)) {
            updatedMedicalData.setId(id);
            return medicalDataRepository.save(updatedMedicalData);
        } else {
            throw new RuntimeException("MedicalData with ID " + id + " not found");
        }
    }

    public void deleteMedicalData(Integer id) {
        if (medicalDataRepository.existsById(id)) {
            medicalDataRepository.deleteById(id);
        } else {
            throw new RuntimeException("MedicalData with ID " + id + " not found");
        }
    }
}

