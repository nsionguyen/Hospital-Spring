package com.lhn.hospital.service;

import com.lhn.hospital.entity.Specialty;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SpecialtyService {
    List<Specialty> getSpecialties();
}
