package com.lhn.hospital.repository;


import com.lhn.hospital.entity.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository  extends JpaRepository<Hospital, Integer> {

}
