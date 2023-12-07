package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.surgeon;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.SurgeonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SurgeonService {

    @Autowired
    private SurgeonRepository surgeonRepository;

    public List<surgeon> getAllSurgeons() {
        return surgeonRepository.findAll();
    }

    public Optional<surgeon> getSurgeonById(Integer id) {
        return surgeonRepository.findById(id);
    }

    public surgeon createSurgeon(surgeon surgeon) {
        return surgeonRepository.save(surgeon);
    }

    public surgeon updateSurgeon(Integer id, surgeon updatedSurgeon) {
        if (surgeonRepository.existsById(id)) {
            updatedSurgeon.setId(id);
            return surgeonRepository.save(updatedSurgeon);
        } else {
            throw new RuntimeException("Surgeon with ID " + id + " not found");
        }
    }

    public void deleteSurgeon(Integer id) {
        if (surgeonRepository.existsById(id)) {
            surgeonRepository.deleteById(id);
        } else {
            throw new RuntimeException("Surgeon with ID " + id + " not found");
        }
    }
}

