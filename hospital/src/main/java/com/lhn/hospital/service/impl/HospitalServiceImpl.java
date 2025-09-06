package com.lhn.hospital.service.impl;

import com.lhn.hospital.entity.Hospital;
import com.lhn.hospital.entity.Specialty;
import com.lhn.hospital.repository.HospitalRepository;
import com.lhn.hospital.repository.SpecialtyRepository;
import com.lhn.hospital.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    @Override
    public List<Hospital> getHospitals() {
        return  hospitalRepository.findAll();
    }


}
