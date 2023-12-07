package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.prescription;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.PrescriptionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public List<prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Optional<prescription> getPrescriptionById(Integer id) {
        return prescriptionRepository.findById(id);
    }

    public prescription createPrescription(prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public prescription updatePrescription(Integer id, prescription updatedPrescription) {
        if (prescriptionRepository.existsById(id)) {
            updatedPrescription.setId(id);
            return prescriptionRepository.save(updatedPrescription);
        } else {
            throw new RuntimeException("Prescription with ID " + id + " not found");
        }
    }

    public void deletePrescription(Integer id) {
        if (prescriptionRepository.existsById(id)) {
            prescriptionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Prescription with ID " + id + " not found");
        }
    }
}

