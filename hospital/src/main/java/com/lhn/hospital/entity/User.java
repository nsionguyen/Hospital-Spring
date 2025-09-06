package com.lhn.hospital.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lhn.hospital.entity.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;


    @NotNull
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;


    @NotNull
    @Column(name = "username", nullable = false, length = 100)
    private String username;


    @NotNull
    @Column(name = "password", nullable = false, length = 100)
    private String password;


    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;


    @NotNull
    @Column(name = "phone", nullable = false, length = 100)
    private String phone;


    @Column(name = "avatar", length = 100)
    private String avatar;

    @Column(name = "active")
    private Boolean active;

    @Lob
    @Column(name = "user_role")
    private String userRole;

    @Lob
    @Column(name = "user_type")
    private String userType;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "last_login_at")
    private Instant lastLoginAt;

    @Transient
    @JsonIgnore
    private MultipartFile fileAvatar;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Doctor doctorProfile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<AppointmentSchedule> appointments;

    @OneToMany(mappedBy = "userReview", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Review> reviews;
}

