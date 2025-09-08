package com.lhn.hospital.controller;


import com.lhn.hospital.entity.Doctor;

import com.lhn.hospital.entity.Review;
import com.lhn.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DoctorRestController {

    private final DoctorService doctorService;

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getDoctors() {

        return ResponseEntity.ok(doctorService.getDoctors());
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable Integer id) {

        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @GetMapping("/doctors/{id}/reviews")
    public ResponseEntity<List<Review>> getViews(@PathVariable Integer id) {
        return new ResponseEntity<>(this.doctorService.getComments(id), HttpStatus.OK);
    }

    @GetMapping("/doctors-booking")
    public ResponseEntity<List<Doctor>> getDoctorsByHospitalAndSpecialty(
            @RequestParam(required = false) Integer hospitalId,
            @RequestParam(required = false) Integer specialtyId) {


        return ResponseEntity.ok(doctorService.getDoctorsByHospitalAndSpecialty(hospitalId, specialtyId));
    }

    @GetMapping("/doctors/search")
    public ResponseEntity<List<Doctor>> searchDoctors(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer specialtyId,
            @RequestParam(required = false) Integer hospitalId) {

        return ResponseEntity.ok(doctorService.searchDoctors(name, specialtyId, hospitalId));
    }
}