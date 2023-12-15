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

    @PutMapping("/{bedId}")
public ResponseEntity<clinicBed> updateBed(@PathVariable Integer bedId, @RequestBody clinicBed updatedBed) {
    Optional<clinicBed> existingBedOptional = clinicBedService.getClinicBedById(bedId);

    if (existingBedOptional.isPresent()) {
        clinicBed existingBed = existingBedOptional.get();
        // Update the properties of the existing bed with the new values
        existingBed.setUnit(updatedBed.getUnit());
        existingBed.setWing(updatedBed.getWing());
        existingBed.setBedLetter(updatedBed.getBedLetter());
        existingBed.setRoomNumber(updatedBed.getRoomNumber());

        // Save the updated bed
        clinicBed savedBed = clinicBedService.updateClinicBed(existingBed.getBedId(),existingBed);
        return ResponseEntity.ok(savedBed);
    } else {
        // Bed not found with the given bedId
        return ResponseEntity.notFound().build();
    }
}

    @DeleteMapping("/{bedId}")
    public void deleteBed(@PathVariable Integer bedId) {
        clinicBedService.deleteClinicBed(bedId);
    }
}

