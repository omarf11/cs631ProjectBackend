package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.surgeryType;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.SurgeryTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeryTypeService {

    @Autowired
    private SurgeryTypeRepository surgeryTypeRepository;

    public List<surgeryType> getAllSurgeryTypes() {
        return surgeryTypeRepository.findAll();
    }

    public Optional<surgeryType> getSurgeryTypeById(Integer id) {
        return surgeryTypeRepository.findById(id);
    }

    public surgeryType createSurgeryType(surgeryType surgeryType) {
        return surgeryTypeRepository.save(surgeryType);
    }

    public surgeryType updateSurgeryType(Integer id, surgeryType updatedSurgeryType) {
        if (surgeryTypeRepository.existsById(id)) {
            updatedSurgeryType.setId(id);
            return surgeryTypeRepository.save(updatedSurgeryType);
        } else {
            throw new RuntimeException("SurgeryType with ID " + id + " not found");
        }
    }

    public void deleteSurgeryType(Integer id) {
        if (surgeryTypeRepository.existsById(id)) {
            surgeryTypeRepository.deleteById(id);
        } else {
            throw new RuntimeException("SurgeryType with ID " + id + " not found");
        }
    }
}

