package com.lhn.hospital.repository;

import com.lhn.hospital.entity.Doctor;
import com.lhn.hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface PatientRepository extends JpaRepository<Patient,Integer>{
    Patient findByName(String name);
    @Query("SELECT p FROM Patient p WHERE p.user.id = :userId")
    List<Patient> findByUserId(@Param("userId") Integer userId);



}
