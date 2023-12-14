package com.nwaHospitalApi.nwaHospitalApi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nwaHospitalApi.nwaHospitalApi.Entities.surgeon;
import com.nwaHospitalApi.nwaHospitalApi.Services.SurgeonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/surgeons")
@CrossOrigin(origins = "http://localhost:3000") 
public class SurgeonController {

    @Autowired
    private SurgeonService surgeonService;

    @GetMapping
    public List<surgeon> getAllSurgeons() {
        return surgeonService.getAllSurgeons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<surgeon> getSurgeonById(@PathVariable Integer id) {
        Optional<surgeon> surgeon = surgeonService.getSurgeonById(id);
        return surgeon.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<surgeon> createSurgeon(@RequestBody surgeon surgeon) {
        surgeon createdSurgeon = surgeonService.createSurgeon(surgeon);
        return new ResponseEntity<>(createdSurgeon, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<surgeon> updateSurgeon(@PathVariable Integer id, @RequestBody surgeon updatedSurgeon) {
        surgeon surgeon = surgeonService.updateSurgeon(id, updatedSurgeon);
        return new ResponseEntity<>(surgeon, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurgeon(@PathVariable Integer id) {
        surgeonService.deleteSurgeon(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

