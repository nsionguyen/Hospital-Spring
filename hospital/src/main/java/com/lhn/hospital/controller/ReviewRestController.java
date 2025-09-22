package com.lhn.hospital.controller;



import com.lhn.hospital.dto.request.PatientDTO;
import com.lhn.hospital.dto.request.ReviewRequest;
import com.lhn.hospital.entity.Doctor;
import com.lhn.hospital.entity.Patient;
import com.lhn.hospital.entity.Review;
import com.lhn.hospital.entity.User;
import com.lhn.hospital.repository.DoctorRepository;
import com.lhn.hospital.repository.ReviewRepository;
import com.lhn.hospital.repository.UserRepository;
import com.lhn.hospital.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReviewRestController {
    private final ReviewService reviewService;
    private final DoctorService doctorService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final DoctorRepository doctorRepository;

@PostMapping("/reviews")
public ResponseEntity<Review> addReview(@RequestBody ReviewRequest request) {
    User user = userRepository.findById(request.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found"));

    Doctor doctor = doctorRepository.findById(request.getDoctorId())
            .orElseThrow(() -> new RuntimeException("Doctor not found"));

    Review review = Review.builder()
            .comment(request.getComment())
            .createdDate(LocalDateTime.now())
            .userReview(user)
            .doctor(doctor)
            .build();

    Review savedReview = reviewService.addReview(review);
    return ResponseEntity.ok(savedReview);
}







}
