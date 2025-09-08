package com.lhn.hospital.service.impl;

import com.lhn.hospital.dto.request.PatientDTO;
import com.lhn.hospital.entity.Patient;
import com.lhn.hospital.entity.User;
import com.lhn.hospital.repository.DoctorRepository;
import com.lhn.hospital.repository.PatientRepository;
import com.lhn.hospital.repository.UserRepository;
import com.lhn.hospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;

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

    @Override
    public Patient createPatient(PatientDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Patient p = new Patient();
        p.setName(dto.getName());
        p.setAge(dto.getAge());
        p.setPhone(dto.getPhone());
        p.setEmail(dto.getEmail());
        p.setHomeTown(dto.getHomeTown());
        p.setGender(dto.getGender());
        p.setUser(user);

        return patientRepository.save(p);
    }


    }

