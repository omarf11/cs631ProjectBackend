package com.nwaHospitalApi.nwaHospitalApi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nwaHospitalApi.nwaHospitalApi.DTOs.PhysicianEmployeeDTO;
import com.nwaHospitalApi.nwaHospitalApi.Entities.physician;
import com.nwaHospitalApi.nwaHospitalApi.Services.PhysicianService;
import com.nwaHospitalApi.nwaHospitalApi.Views.PhysicianView;

import java.util.List;

@RestController
@RequestMapping("/physicians")
@CrossOrigin(origins = "*", allowedHeaders = { "Authorization", "content-Type" }, methods = { RequestMethod.GET,
    RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
    public class PhysicianController {

    @Autowired
    private PhysicianService physicianService;

    @GetMapping
    public List<PhysicianEmployeeDTO> getAllPhysicians() {
        return physicianService.getAllPhysicians();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhysicianView> getPhysicianById(@PathVariable Integer id) {
        PhysicianView physician = physicianService.getPhysicianByEmployeeId(id);
        return new ResponseEntity<>(physician, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<physician> createPhysician(@RequestBody physician physician) {
        physician createdPhysician = physicianService.createPhysician(physician);
        return new ResponseEntity<>(createdPhysician, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<physician> updatePhysician(@PathVariable Integer id, @RequestBody physician updatedPhysician) {
        physician physician = physicianService.updatePhysician(id, updatedPhysician);
        return new ResponseEntity<>(physician, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhysician(@PathVariable Integer id) {
        physicianService.deletePhysician(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

