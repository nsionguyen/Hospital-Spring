package com.lhn.hospital.service;

import com.lhn.hospital.entity.Doctor;
import com.lhn.hospital.entity.Hospital;
import com.lhn.hospital.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DoctorService {
    List<Doctor> getDoctors();
    List<Doctor> getDoctorsByHospitalAndSpecialty(Integer hospitalId, Integer specialtyId);
    Optional<Doctor> getDoctorById(Integer id);
    List<Review> getComments(Integer id);
    List<Doctor> searchDoctors(String name, Integer specialtyId, Integer hospitalId);
}
