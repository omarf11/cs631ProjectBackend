package com.nwaHospitalApi.nwaHospitalApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwaHospitalApi.nwaHospitalApi.Entities.consultation;
import com.nwaHospitalApi.nwaHospitalApi.Repositories.ConsultationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    public List<consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    public Optional<consultation> getConsultationById(Integer id) {
        return consultationRepository.findById(id);
    }

    public consultation createConsultation(consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public consultation updateConsultation(Integer id, consultation updatedConsultation) {
        if (consultationRepository.existsById(id)) {
            updatedConsultation.setId(id);
            return consultationRepository.save(updatedConsultation);
        } else {
            throw new RuntimeException("Consultation with ID " + id + " not found");
        }
    }

    public void deleteConsultation(Integer id) {
        if (consultationRepository.existsById(id)) {
            consultationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Consultation with ID " + id + " not found");
        }
    }
}

