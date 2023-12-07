package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.nurse;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.NurseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    public List<nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    public Optional<nurse> getNurseById(Integer id) {
        return nurseRepository.findById(id);
    }

    public nurse createNurse(nurse nurse) {
        return nurseRepository.save(nurse);
    }

    public nurse updateNurse(Integer id, nurse updatedNurse) {
        if (nurseRepository.existsById(id)) {
            updatedNurse.setId(id);
            return nurseRepository.save(updatedNurse);
        } else {
            throw new RuntimeException("Nurse with ID " + id + " not found");
        }
    }

    public void deleteNurse(Integer id) {
        if (nurseRepository.existsById(id)) {
            nurseRepository.deleteById(id);
        } else {
            throw new RuntimeException("Nurse with ID " + id + " not found");
        }
    }
}
