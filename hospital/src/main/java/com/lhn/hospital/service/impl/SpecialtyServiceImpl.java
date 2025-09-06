package com.lhn.hospital.service.impl;

import com.lhn.hospital.entity.Specialty;
import com.lhn.hospital.repository.SpecialtyRepository;
import com.lhn.hospital.service.SpecialtyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    @Override
    public List<Specialty> getSpecialties() {
        return specialtyRepository.findAll();
    }
}
