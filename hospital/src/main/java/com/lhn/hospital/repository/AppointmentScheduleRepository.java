package com.lhn.hospital.repository;

import com.lhn.hospital.dto.request.AppointmentScheduleDTO;
import com.lhn.hospital.dto.response.AppointmentSchedulesDTO;
import com.lhn.hospital.entity.AppointmentSchedule;
import com.lhn.hospital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentScheduleRepository extends JpaRepository<AppointmentSchedule,Integer> {
    List<AppointmentSchedule> findByUser(User user);

    @Query("SELECT new com.lhn.hospital.dto.response.AppointmentSchedulesDTO(a.doctor.id, a.date) " +
            "FROM AppointmentSchedule a " +
            "WHERE a.doctor.id = :doctorId " +
            "AND a.status = com.lhn.hospital.entity.enums.AppointmentScheduleStatus.ACCEPT")
    List<AppointmentSchedulesDTO> findByDoctorId(@Param("doctorId") Integer doctorId);



}
