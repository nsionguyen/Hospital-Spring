package com.lhn.hospital.repository;

import com.lhn.hospital.entity.AppointmentSchedule;
import com.lhn.hospital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentScheduleRepository extends JpaRepository<AppointmentSchedule,Integer> {
    List<AppointmentSchedule> findByUser(User user);

}
