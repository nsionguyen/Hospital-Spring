package com.lhn.hospital.controller;



import com.lhn.hospital.entity.Hospital;
import com.lhn.hospital.entity.Specialty;
import com.lhn.hospital.service.HospitalService;
import com.lhn.hospital.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HospitalRestController {

    private final HospitalService hospitalService;

    @GetMapping("/hospitals")
    public ResponseEntity<List<Hospital>> getHospitals() {
        return ResponseEntity.ok(hospitalService.getHospitals());
    }



}