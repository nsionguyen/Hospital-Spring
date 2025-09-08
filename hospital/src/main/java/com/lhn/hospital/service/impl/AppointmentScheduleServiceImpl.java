package com.lhn.hospital.service.impl;


import com.lhn.hospital.dto.request.AppointmentScheduleDTO;
import com.lhn.hospital.dto.response.AppointmentSchedulesDTO;
import com.lhn.hospital.entity.AppointmentSchedule;
import com.lhn.hospital.entity.Doctor;
import com.lhn.hospital.entity.Patient;
import com.lhn.hospital.entity.User;
import com.lhn.hospital.entity.enums.AppointmentScheduleStatus;
import com.lhn.hospital.repository.*;
import com.lhn.hospital.service.AppointmentScheduleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentScheduleServiceImpl implements AppointmentScheduleService {

    private final AppointmentScheduleRepository appointmentScheduleRepository;

    private final UserRepository userRepository;

    private final DoctorRepository doctorRepository;

    private final PatientRepository patientRepository;

    @Override
    public List<AppointmentSchedule> getAppointmentSchedulesUser(int booked_by) {
        User u = userRepository.findById(booked_by);
        return appointmentScheduleRepository.findByUser(u);
    }
    @Override
    @Transactional
    public void createAppointment(AppointmentScheduleDTO dto) {
        try {

            Doctor doctor = doctorRepository.findById(dto.getDoctor())
                    .orElseThrow(() -> new RuntimeException("Bác sĩ không tồn tại"));
            Patient patient = patientRepository.findById(dto.getPatient())
                    .orElseThrow(() -> new RuntimeException("Bệnh nhân không tồn tại"));
            User user = userRepository.findById(dto.getBookBy())
                    .orElseThrow(() -> new RuntimeException("Bệnh viện không tồn tại"));

            // Chuyển đổi appointment_date từ String thành LocalDateTime
            LocalDateTime appointmentDateTime = LocalDateTime.parse(dto.getAppointment_date());

            // Chuyển đổi DTO thành entity AppointmentSchedule
            AppointmentSchedule appointmentSchedule = new AppointmentSchedule();
            appointmentSchedule.setDoctor(doctor);
            appointmentSchedule.setPatient(patient);
            appointmentSchedule.setUser(user);
            appointmentSchedule.setSymptom(dto.getSymptoms());
            appointmentSchedule.setDate(appointmentDateTime);

            // Lưu vào database
            appointmentScheduleRepository.save(appointmentSchedule);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi tạo lịch hẹn: " + e.getMessage(), e);
        }
    }


    @Override
    public List<AppointmentSchedulesDTO> getAppointmentsByDoctorId(Integer doctorId) {

        return appointmentScheduleRepository.findByDoctorId(doctorId);
    }

    @Override
    public void cancelAppointment(Integer id) {
        AppointmentSchedule schedule = appointmentScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy lịch hẹn"));

        schedule.setStatus(AppointmentScheduleStatus.CANCEL);
        appointmentScheduleRepository.save(schedule);
    }
}
