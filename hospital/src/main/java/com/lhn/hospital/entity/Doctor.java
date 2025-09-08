package com.lhn.hospital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "doctor")

public class Doctor {

    @Id
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "image")
    private String image;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "certificate")
    private String certificate;

    @Column(name = "start_time")
    @Builder.Default
    private LocalDateTime startTime = LocalDateTime.now();

    @Column(name = "end_time")
    @Builder.Default
    private LocalDateTime endTime = LocalDateTime.now();

    @Column(name = "room")
    private String room;

    @Column(name = "experience_years")
    private Integer experienceYears;

    @ManyToOne()
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @ManyToOne()
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<AppointmentSchedule> appointments;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Review> reviews;
}
