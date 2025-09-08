package com.lhn.hospital.controller;


import com.lhn.hospital.dto.request.AppointmentScheduleDTO;
import com.lhn.hospital.dto.response.AppointmentSchedulesDTO;
import com.lhn.hospital.entity.AppointmentSchedule;
import com.lhn.hospital.entity.Doctor;
import com.lhn.hospital.service.AppointmentScheduleService;
import com.lhn.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppointmentScheduleRestController {

    private final AppointmentScheduleService appointmentScheduleService;

    @GetMapping("/secure/appointmentSchedulesUser/{bookedById}")
    public ResponseEntity<List<AppointmentSchedule>> getDoctors(@PathVariable Integer bookedById) {

        return ResponseEntity.ok(appointmentScheduleService.getAppointmentSchedulesUser(bookedById));
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


    @GetMapping("/appointments/calendar/{doctorId}")
    public List<Map<String, Object>> getAppointmentsForCalendar(@PathVariable Integer doctorId) {
        List<AppointmentSchedulesDTO> list = appointmentScheduleService.getAppointmentsByDoctorId(doctorId);


        return list.stream().map(a -> {
            Map<String, Object> map = new HashMap<>();
            map.put("title", "Đã có hẹn ");
            map.put("start", a.getDate());
            map.put("end", a.getDate().plusMinutes(45));
            return map;
        }).collect(Collectors.toList());
    }


    @PutMapping("/secure/appointments/{id}/cancel")
    public ResponseEntity<String> cancel(@PathVariable Integer id) {
        appointmentScheduleService.cancelAppointment(id);
        return ResponseEntity.ok("Hủy lịch thành công");
    }
}




