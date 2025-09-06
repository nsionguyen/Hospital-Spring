package com.lhn.hospital.service;

import com.lhn.hospital.entity.Doctor;
import com.lhn.hospital.entity.Hospital;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DoctorService {
    List<Doctor> getDoctors();
    List<Doctor> getDoctorsByHospitalAndSpecialty(Integer hospitalId, Integer specialtyId);
}
