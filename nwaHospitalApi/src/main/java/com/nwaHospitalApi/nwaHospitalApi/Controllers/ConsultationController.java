package com.nwaHospitalApi.nwaHospitalApi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nwaHospitalApi.nwaHospitalApi.Entities.consultation;
import com.nwaHospitalApi.nwaHospitalApi.Services.ConsultationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @GetMapping
    public List<consultation> getAllConsultations() {
        return consultationService.getAllConsultations();
    }

    @GetMapping("/{physicianId}")
    public ResponseEntity<List<consultation>> getConsultationById(@PathVariable Integer physicianId) {
        List<consultation> consultation = consultationService.getConsultationByPhysicianId(physicianId);
        return  new ResponseEntity<>(consultation, HttpStatus.OK);
               
    }

    @PostMapping
    public ResponseEntity<consultation> createConsultation(@RequestBody consultation consultation) {
        consultation createdConsultation = consultationService.createConsultation(consultation);
        return new ResponseEntity<>(createdConsultation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<consultation> updateConsultation(@PathVariable Integer id, @RequestBody consultation updatedConsultation) {
        consultation consultation = consultationService.updateConsultation(id, updatedConsultation);
        return new ResponseEntity<>(consultation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsultation(@PathVariable Integer id) {
        consultationService.deleteConsultation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

