package com.nwaHospitalApi.nwaHospitalApi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nwaHospitalApi.nwaHospitalApi.DTOs.SurgeryDTO;
import com.nwaHospitalApi.nwaHospitalApi.Entities.CreateSurgeryRequest;
import com.nwaHospitalApi.nwaHospitalApi.Entities.surgery;
import com.nwaHospitalApi.nwaHospitalApi.Entities.surgeryType;
import com.nwaHospitalApi.nwaHospitalApi.Services.SurgeryService;
import com.nwaHospitalApi.nwaHospitalApi.Services.SurgeryTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/surgeries")
@CrossOrigin(origins = "http://localhost:3000") 
public class SurgeryController {

    @Autowired
    private SurgeryService surgeryService;

    @Autowired
    private SurgeryTypeService surgeryTypeService;

    @GetMapping
    public List<surgery> getAllSurgeries() {
        return surgeryService.getAllSurgeries();
    }
    @GetMapping("/schedule")
    public List<SurgeryDTO> getSurgerySchedule() {
        return surgeryService.getSurgerySchedule();
    }

    @GetMapping("/{id}")
    public ResponseEntity<surgery> getSurgeryById(@PathVariable Integer id) {
        Optional<surgery> surgery = surgeryService.getSurgeryById(id);
        return surgery.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<surgery> createSurgery(@RequestBody CreateSurgeryRequest surgery) {
        surgery createdSurgery = surgeryService.createSurgery(surgery);
        return new ResponseEntity<>(createdSurgery, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<surgery> updateSurgery(@PathVariable Integer id, @RequestBody surgery updatedSurgery) {
        surgery surgery = surgeryService.updateSurgery(id, updatedSurgery);
        return new ResponseEntity<>(surgery, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurgery(@PathVariable Integer id) {
        surgeryService.deleteSurgery(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/surgeryTypes")
    public ResponseEntity<List<surgeryType>> getAllSurgeryTypes(){
     List<surgeryType> surgeryTypes =   surgeryTypeService.getAllSurgeryTypes();

    return new ResponseEntity<>(surgeryTypes, HttpStatus.OK);
    }
}

