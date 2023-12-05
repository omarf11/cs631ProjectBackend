package com.nwaHospitalApi.nwaHospitalApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nwaHospitalApi.nwaHospitalApi.Entities.illness;
import com.nwaHospitalApi.nwaHospitalApi.Services.IllnessService;

@RestController
@Controller
@RequestMapping("/illness")
public class IllnessController {
    
    private final IllnessService illnessService;

     @Autowired
    public IllnessController(IllnessService illnessService) {
        this.illnessService = illnessService;
    }

     @GetMapping
    public ResponseEntity<List<illness>> getAllEmployees() {
        List<illness> illnesses = illnessService.getAllIllnesses();
        return new ResponseEntity<>(illnesses, HttpStatus.OK);
    }
}
