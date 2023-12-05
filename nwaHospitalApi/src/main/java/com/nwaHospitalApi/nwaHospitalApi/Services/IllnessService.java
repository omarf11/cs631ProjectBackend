package com.nwaHospitalApi.nwaHospitalApi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.illness;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.IllnessRepository;

@Service
public class IllnessService {
    
        private final IllnessRepository illnessRepository;

    @Autowired
    public IllnessService(IllnessRepository illnessRepository) {
        this.illnessRepository = illnessRepository;
    }

    public List<illness> getAllIllnesses() {
        return illnessRepository.findAll();
    }

    public Optional<illness> getIllnessById(Integer id) {
        return illnessRepository.findById(id);
    }

    public illness saveIllness(illness illness) {
        return illnessRepository.save(illness);
    }

    public void deleteIllness(Integer id) {
        illnessRepository.deleteById(id);
    }
}
