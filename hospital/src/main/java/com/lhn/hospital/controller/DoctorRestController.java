package com.lhn.hospital.controller;


import com.lhn.hospital.entity.Doctor;

import com.lhn.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DoctorRestController {

    private final DoctorService doctorService;

    @GetMapping("/doctor")
    public ResponseEntity<List<Doctor>> getDoctors() {
        return ResponseEntity.ok(doctorService.getDoctors());
    }

    @GetMapping("/doctors-booking")
    public ResponseEntity<List<Doctor>> getDoctorsByHospitalAndSpecialty(
            @RequestParam(required = false) Integer hospitalId,
            @RequestParam(required = false) Integer specialtyId) {


        return ResponseEntity.ok(doctorService.getDoctorsByHospitalAndSpecialty(hospitalId, specialtyId));
    }
}