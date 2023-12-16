package com.nwaHospitalApi.nwaHospitalApi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nwaHospitalApi.nwaHospitalApi.DTOs.PatientClinicBedDTO;
import com.nwaHospitalApi.nwaHospitalApi.Entities.clinicBed;
import com.nwaHospitalApi.nwaHospitalApi.Services.ClinicBedService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/beds")
@CrossOrigin(origins = "*", allowedHeaders = { "Authorization", "content-Type" }, methods = { RequestMethod.GET,
        RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS  })
public class ClinicBedController {

    private final ClinicBedService clinicBedService;

    @Autowired
    public ClinicBedController(ClinicBedService clinicBedService) {
        this.clinicBedService = clinicBedService;
    }

    @GetMapping
    public List<PatientClinicBedDTO> getAllBeds() {
        return clinicBedService.getAllClinicBeds();
    }

    @GetMapping("/{bedId}")
    public Optional<clinicBed> getBedById(@PathVariable Integer bedId) {
        return clinicBedService.getClinicBedById(bedId);
    }

    @PutMapping("/{bedId}/{patientId}")
    public ResponseEntity<clinicBed> updateBed(@PathVariable Integer bedId, @PathVariable Integer patientId) {
        Optional<clinicBed> existingBedOptional = clinicBedService.getClinicBedById(bedId);

        if (existingBedOptional.isPresent()) {

            // Save the updated bed
            clinicBed savedBed = clinicBedService.updateClinicBedPatient(bedId, patientId);
            return ResponseEntity.ok(savedBed);
        } else {
            // Bed not found with the given bedId
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/remove/{bedId}")
    public ResponseEntity<clinicBed> removePatientIdByBedId(@PathVariable Integer bedId) {
        Optional<clinicBed> existingBedOptional = clinicBedService.getClinicBedById(bedId);

        if (existingBedOptional.isPresent()) {
            clinicBed existingBed = existingBedOptional.get();

            // Save the updated bed
            clinicBed savedBed = clinicBedService.updateClinicBed(existingBed.getBedId(), existingBed);
            return ResponseEntity.ok(savedBed);
        } else {
            // Bed not found with the given bedId
            return ResponseEntity.notFound().build();
        }
    }


    // @DeleteMapping("/{bedId}")
    // public void deleteBed(@PathVariable Integer bedId) {
    //     clinicBedService.deleteClinicBed(bedId);
    // }
}
