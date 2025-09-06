package com.lhn.hospital.service;

import com.lhn.hospital.entity.Hospital;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HospitalService {

    List<Hospital> getHospitals();
}
