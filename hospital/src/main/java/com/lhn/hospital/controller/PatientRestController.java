package com.lhn.hospital.controller;



import com.lhn.hospital.entity.Patient;

import com.lhn.hospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PatientRestController {
    private final PatientService patientService;



    @GetMapping("/patients-booking")
    public ResponseEntity<List<Patient>> getPatientsBooking() {
        List<Patient> patients = patientService.getPatientsByUserId(1);
        return ResponseEntity.ok(patients);
    }

    @PostMapping("/patients")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.createPatient(patient);
        return ResponseEntity.ok(savedPatient);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }



    }



