package com.lhn.hospital.controller;


import com.lhn.hospital.dto.request.AppointmentScheduleDTO;
import com.lhn.hospital.entity.AppointmentSchedule;
import com.lhn.hospital.entity.Doctor;
import com.lhn.hospital.service.AppointmentScheduleService;
import com.lhn.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppointmentScheduleRestController {

    private final AppointmentScheduleService appointmentScheduleService;

    @GetMapping("/appointmentSchedulesUser")
    public ResponseEntity<List<AppointmentSchedule>> getDoctors() {

        return ResponseEntity.ok(appointmentScheduleService.getAppointmentSchedulesUser(1));
    }

    @PostMapping("/appointmentSchedules")
    public ResponseEntity<String> createAppointment(@RequestBody AppointmentScheduleDTO dto) {
        try {
            appointmentScheduleService.createAppointment(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Lịch hẹn đã được đặt thành công.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Đặt lịch thất bại: " + e.getMessage());
        }
    }



}
