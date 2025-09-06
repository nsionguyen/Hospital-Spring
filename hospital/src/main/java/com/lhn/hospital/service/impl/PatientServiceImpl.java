package com.lhn.hospital.service.impl;

import com.lhn.hospital.entity.Patient;
import com.lhn.hospital.repository.DoctorRepository;
import com.lhn.hospital.repository.PatientRepository;
import com.lhn.hospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    public Patient findByName(String name){
        return patientRepository.findByName(name);
    }

   @Override
    public List<Patient> getPatientsByUserId(Integer userId) {
        return patientRepository.findByUserId(userId);
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }


    }

