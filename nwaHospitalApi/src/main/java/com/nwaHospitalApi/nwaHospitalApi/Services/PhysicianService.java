package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.physician;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.PhysicianRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PhysicianService {

    @Autowired
    private PhysicianRepository physicianRepository;

    public List<physician> getAllPhysicians() {
        return physicianRepository.findAll();
    }

    public Optional<physician> getPhysicianById(Integer id) {
        return physicianRepository.findById(id);
    }

    public physician createPhysician(physician physician) {
        return physicianRepository.save(physician);
    }

    public physician updatePhysician(Integer id, physician updatedPhysician) {
        if (physicianRepository.existsById(id)) {
            updatedPhysician.setId(id);
            return physicianRepository.save(updatedPhysician);
        } else {
            throw new RuntimeException("Physician with ID " + id + " not found");
        }
    }

    public void deletePhysician(Integer id) {
        if (physicianRepository.existsById(id)) {
            physicianRepository.deleteById(id);
        } else {
            throw new RuntimeException("Physician with ID " + id + " not found");
        }
    }
}

