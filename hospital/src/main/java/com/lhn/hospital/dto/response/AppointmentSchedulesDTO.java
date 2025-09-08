package com.lhn.hospital.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class AppointmentSchedulesDTO {
    private Integer doctorId;
    private LocalDateTime date;
}
