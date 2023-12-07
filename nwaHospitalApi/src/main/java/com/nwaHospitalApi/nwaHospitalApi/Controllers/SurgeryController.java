package com.nwaHospitalApi.nwaHospitalApi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nwaHospitalApi.nwaHospitalApi.Entities.surgery;
import com.nwaHospitalApi.nwaHospitalApi.Services.SurgeryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/surgeries")
public class SurgeryController {

    @Autowired
    private SurgeryService surgeryService;

    @GetMapping
    public List<surgery> getAllSurgeries() {
        return surgeryService.getAllSurgeries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<surgery> getSurgeryById(@PathVariable Long id) {
        Optional<surgery> surgery = surgeryService.getSurgeryById(id);
        return surgery.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<surgery> createSurgery(@RequestBody surgery surgery) {
        surgery createdSurgery = surgeryService.createSurgery(surgery);
        return new ResponseEntity<>(createdSurgery, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<surgery> updateSurgery(@PathVariable Long id, @RequestBody surgery updatedSurgery) {
        surgery surgery = surgeryService.updateSurgery(id, updatedSurgery);
        return new ResponseEntity<>(surgery, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurgery(@PathVariable Long id) {
        surgeryService.deleteSurgery(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

