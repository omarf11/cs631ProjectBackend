package com.nwaHospitalApi.nwaHospitalApi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nwaHospitalApi.nwaHospitalApi.DTOs.NurseEmployeeDTO;
import com.nwaHospitalApi.nwaHospitalApi.Entities.nurse;
import com.nwaHospitalApi.nwaHospitalApi.Services.NurseService;
import com.nwaHospitalApi.nwaHospitalApi.Views.NurseView;

import java.util.List;

@RestController
@RequestMapping("/nurses")
@CrossOrigin(origins = "http://localhost:3000") 
public class NurseController {

    @Autowired
    private NurseService nurseService;

    @GetMapping
    public ResponseEntity<List<NurseEmployeeDTO>> getAllNurses() {
        List<NurseEmployeeDTO> nurses = nurseService.getAllNursesEmployeeInfo();
        return new ResponseEntity<>(nurses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NurseView> getNurseById(@PathVariable Integer id) {
        NurseView nurse = nurseService.getNurseByEmployee_Id(id);
        return  new ResponseEntity<>(nurse, HttpStatus.OK);
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
