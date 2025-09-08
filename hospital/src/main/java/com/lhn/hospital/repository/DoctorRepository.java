package com.lhn.hospital.repository;

import com.lhn.hospital.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    List<Doctor> findByHospitalIdAndSpecialtyId(Integer hospitalId, Integer specialtyId);

    @Query("SELECT d FROM Doctor d " +
            "WHERE (:name IS NULL OR LOWER(d.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:specialtyId IS NULL OR d.specialty.id = :specialtyId) " +
            "AND (:hospitalId IS NULL OR d.hospital.id = :hospitalId)")
    List<Doctor> searchDoctors(@Param("name") String name,
                               @Param("specialtyId") Integer specialtyId,
                               @Param("hospitalId") Integer hospitalId);

}
