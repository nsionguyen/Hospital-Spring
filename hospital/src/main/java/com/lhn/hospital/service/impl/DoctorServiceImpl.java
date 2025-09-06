package com.lhn.hospital.service.impl;


import com.lhn.hospital.entity.Doctor;

import com.lhn.hospital.repository.DoctorRepository;

import com.lhn.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor> getDoctorsByHospitalAndSpecialty(Integer hospitalId, Integer specialtyId) {
        return doctorRepository.findByHospitalIdAndSpecialtyId(hospitalId, specialtyId);
    }
}
