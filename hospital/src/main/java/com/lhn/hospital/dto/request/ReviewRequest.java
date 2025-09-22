package com.lhn.hospital.dto.request;

import lombok.Data;

@Data
public class ReviewRequest {
    private String comment;
    private Integer userId;
    private Integer doctorId;
}
