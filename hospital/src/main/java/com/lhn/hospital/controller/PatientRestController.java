package com.lhn.hospital.controller;



import com.lhn.hospital.dto.request.PatientDTO;
import com.lhn.hospital.entity.Patient;

import com.lhn.hospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PatientRestController {
    private final PatientService patientService;



    @GetMapping("/secure/patients-booking/{userId}")
    public ResponseEntity<List<Patient>> getPatientsBooking( @PathVariable Integer userId) {
        List<Patient> patients = patientService.getPatientsByUserId(userId);
        return ResponseEntity.ok(patients);
    }





    @PostMapping("/secure/patients")
    public ResponseEntity<Patient> createPatient(@RequestBody PatientDTO dto) {
        Patient saved = patientService.createPatient(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


    }









