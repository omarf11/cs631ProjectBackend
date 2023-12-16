package com.nwaHospitalApi.nwaHospitalApi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nwaHospitalApi.nwaHospitalApi.Entities.patient;
import com.nwaHospitalApi.nwaHospitalApi.Services.PatientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "*", allowedHeaders = { "Authorization", "content-Type" },
        methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS })

    public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<patient> getPatientById(@PathVariable Integer id) {
        Optional<patient> patient = patientService.getPatientById(id);
        return patient.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<patient> createPatient(@RequestBody patient patient) {
        patient createdPatient = patientService.createPatient(patient);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<patient> updatePatient(@PathVariable Integer id, @RequestBody patient updatedPatient) {
        patient patient = patientService.updatePatient(id, updatedPatient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Integer id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/physician/{physicianId}")
    public ResponseEntity<patient> updatePatientsPhysicianId(@PathVariable Integer id ,  @PathVariable Integer physicianId) {

        patient p = patientService.updatePatientPhysId(id , physicianId);

        return new ResponseEntity<>(p , HttpStatus.OK);
    }
    @PutMapping("/{id}/nurse/{nurseId}")
    public ResponseEntity<patient> updatePatientsNurseId(@PathVariable Integer id , @PathVariable Integer nurseId) {
        System.out.println("NURSEID IN CONTROLLER: " + nurseId);
        patient p = patientService.updatePatientNurseId(id , nurseId);

        return new ResponseEntity<>(p , HttpStatus.OK);
    }

    @PutMapping("/{id}/removeNurse")
    public ResponseEntity<patient> removeNurseId(@PathVariable Integer id ) {
        System.out.println("NURSEID IN CONTROLLER:");
        patient p = patientService.updatePatientNurseId(id , null);

        return new ResponseEntity<>(p , HttpStatus.OK);
    }



}

