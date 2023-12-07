package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.allergy;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.AllergyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AllergyService {

    @Autowired
    private AllergyRepository allergyRepository;

    public List<allergy> getAllAllergies() {
        return allergyRepository.findAll();
    }

    public Optional<allergy> getAllergyById(Integer allergyId) {
        return allergyRepository.findById(allergyId);
    }

    public allergy createAllergy(allergy allergy) {
        return allergyRepository.save(allergy);
    }

    public allergy updateAllergy(Integer allergyId, allergy updatedAllergy) {
        if (allergyRepository.existsById(allergyId)) {
            updatedAllergy.setAllergyId(allergyId);
            return allergyRepository.save(updatedAllergy);
        } else {
            throw new RuntimeException("Allergy with ID " + allergyId + " not found");
        }
    }

    public void deleteAllergy(Integer allergyId) {
        if (allergyRepository.existsById(allergyId)) {
            allergyRepository.deleteById(allergyId);
        } else {
            throw new RuntimeException("Allergy with ID " + allergyId + " not found");
        }
    }
}

