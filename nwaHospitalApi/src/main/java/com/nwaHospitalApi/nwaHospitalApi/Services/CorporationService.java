package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.corporation;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.CorporationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CorporationService {

    @Autowired
    private CorporationRepository corporationRepository;

    public List<corporation> getAllCorporations() {
        return corporationRepository.findAll();
    }

    public Optional<corporation> getCorporationById(Integer id) {
        return corporationRepository.findById(id);
    }

    public corporation createCorporation(corporation corporation) {
        return corporationRepository.save(corporation);
    }

    public corporation updateCorporation(Integer id, corporation updatedCorporation) {
        if (corporationRepository.existsById(id)) {
            updatedCorporation.setId(id);
            return corporationRepository.save(updatedCorporation);
        } else {
            throw new RuntimeException("Corporation with ID " + id + " not found");
        }
    }

    public void deleteCorporation(Integer id) {
        if (corporationRepository.existsById(id)) {
            corporationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Corporation with ID " + id + " not found");
        }
    }
}

