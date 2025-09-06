package com.lhn.hospital.entity;

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
@Table(name = "profile_patient")
public class ProfilePatient {

    @Id
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private AppointmentSchedule appointment;

    @Column(name = "diagnose")
    private String diagnose;

    @Column(name = "medical_history")
    private String medicalHistory;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patientPro;

    @Column(name = "created_date")
    @Builder.Default
    private LocalDateTime createdDate = LocalDateTime.now();
}

