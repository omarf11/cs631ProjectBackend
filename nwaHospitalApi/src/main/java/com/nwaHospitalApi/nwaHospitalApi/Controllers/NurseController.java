package com.nwaHospitalApi.nwaHospitalApi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nwaHospitalApi.nwaHospitalApi.Entities.nurse;
import com.nwaHospitalApi.nwaHospitalApi.Services.NurseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nurses")
public class NurseController {

    @Autowired
    private NurseService nurseService;

    @GetMapping
    public List<nurse> getAllNurses() {
        return nurseService.getAllNurses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<nurse> getNurseById(@PathVariable Integer id) {
        Optional<nurse> nurse = nurseService.getNurseById(id);
        return nurse.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<nurse> createNurse(@RequestBody nurse nurse) {
        nurse createdNurse = nurseService.createNurse(nurse);
        return new ResponseEntity<>(createdNurse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<nurse> updateNurse(@PathVariable Integer id, @RequestBody nurse updatedNurse) {
        nurse nurse = nurseService.updateNurse(id, updatedNurse);
        return new ResponseEntity<>(nurse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNurse(@PathVariable Integer id) {
        nurseService.deleteNurse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
