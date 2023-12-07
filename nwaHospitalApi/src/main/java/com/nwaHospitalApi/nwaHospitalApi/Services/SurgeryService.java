package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.surgery;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.SurgeryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryService {

    @Autowired
    private SurgeryRepository surgeryRepository;

    public List<surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    public Optional<surgery> getSurgeryById(Long id) {
        return surgeryRepository.findById(id);
    }

    public surgery createSurgery(surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    public surgery updateSurgery(Long id, surgery updatedSurgery) {
        if (surgeryRepository.existsById(id)) {
            updatedSurgery.setId(id);
            return surgeryRepository.save(updatedSurgery);
        } else {
            throw new RuntimeException("Surgery with ID " + id + " not found");
        }
    }

    public void deleteSurgery(Long id) {
        if (surgeryRepository.existsById(id)) {
            surgeryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Surgery with ID " + id + " not found");
        }
    }
}

