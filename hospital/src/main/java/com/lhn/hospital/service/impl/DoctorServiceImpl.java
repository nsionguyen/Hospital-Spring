package com.lhn.hospital.service.impl;


import com.lhn.hospital.entity.Doctor;

import com.lhn.hospital.entity.Review;
import com.lhn.hospital.repository.DoctorRepository;

import com.lhn.hospital.repository.ReviewRepository;
import com.lhn.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor> getDoctorsByHospitalAndSpecialty(Integer hospitalId, Integer specialtyId) {
        return doctorRepository.findByHospitalIdAndSpecialtyId(hospitalId, specialtyId);
    }

    @Override
    public Optional<Doctor> getDoctorById(Integer id) {
        return doctorRepository.findById(id);
    }

    @Override
    public List<Review> getComments(Integer id){
        return reviewRepository.findByDoctor_Id(id);
    }
    @Override
    public List<Doctor> searchDoctors(String name, Integer specialtyId, Integer hospitalId) {
        return doctorRepository.searchDoctors(name, specialtyId, hospitalId);
    }
}
