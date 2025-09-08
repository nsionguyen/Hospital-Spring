package com.lhn.hospital.service;

import com.lhn.hospital.dto.request.AppointmentScheduleDTO;
import com.lhn.hospital.dto.response.AppointmentSchedulesDTO;
import com.lhn.hospital.entity.AppointmentSchedule;
import com.lhn.hospital.entity.Doctor;
import com.lhn.hospital.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public interface AppointmentScheduleService {
    List<AppointmentSchedule> getAppointmentSchedulesUser(int booked_by);
    void createAppointment(AppointmentScheduleDTO dto);
    List<AppointmentSchedulesDTO> getAppointmentsByDoctorId(Integer doctorId);
}
