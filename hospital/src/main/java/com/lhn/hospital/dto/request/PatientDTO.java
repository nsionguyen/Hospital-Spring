package com.lhn.hospital.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PatientDTO {
    private String name;
    private Integer age;
    private String phone;
    private String email;
    private String homeTown;
    private String gender;
    private Integer userId;
}
