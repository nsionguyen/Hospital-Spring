package com.lhn.hospital.service;

import com.lhn.hospital.dto.request.PatientDTO;
import com.lhn.hospital.entity.Doctor;
import com.lhn.hospital.entity.Hospital;
import com.lhn.hospital.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PatientService  {
    Patient findByName(String name);
    List<Patient> getPatientsByUserId(Integer userId);
    public Patient createPatient(PatientDTO dto);

    Patient createPatient(Patient patient);
    List<Patient> getAllPatients();


}
