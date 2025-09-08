package com.lhn.hospital.entity;

import com.lhn.hospital.entity.enums.AppointmentScheduleStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "appointment_schedule")
public class AppointmentSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "created_date")
    @Builder.Default
    private LocalDateTime createdDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AppointmentScheduleStatus status = AppointmentScheduleStatus.ACCEPT;

    @Column(name = "note")
    private String note;

    @Column(name = "symptom")
    private String symptom;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "booked_by")
    private User user;

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
    private Payment payment;
}

