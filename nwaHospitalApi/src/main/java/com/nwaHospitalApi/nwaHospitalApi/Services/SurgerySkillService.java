package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.surgerySkill;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.SurgerySkillRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SurgerySkillService {

    @Autowired
    private SurgerySkillRepository surgerySkillRepository;

    public List<surgerySkill> getAllSurgerySkills() {
        return surgerySkillRepository.findAll();
    }

    public Optional<surgerySkill> getSurgerySkillById(Integer id) {
        return surgerySkillRepository.findById(id);
    }

    public surgerySkill createSurgerySkill(surgerySkill surgerySkill) {
        return surgerySkillRepository.save(surgerySkill);
    }

    public surgerySkill updateSurgerySkill(Integer id, surgerySkill updatedSurgerySkill) {
        if (surgerySkillRepository.existsById(id)) {
            updatedSurgerySkill.setId(id);
            return surgerySkillRepository.save(updatedSurgerySkill);
        } else {
            throw new RuntimeException("SurgerySkill with ID " + id + " not found");
        }
    }

    public void deleteSurgerySkill(Integer id) {
        if (surgerySkillRepository.existsById(id)) {
            surgerySkillRepository.deleteById(id);
        } else {
            throw new RuntimeException("SurgerySkill with ID " + id + " not found");
        }
    }
}

