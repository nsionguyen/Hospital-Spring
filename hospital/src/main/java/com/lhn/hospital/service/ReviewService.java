package com.lhn.hospital.service;

import com.lhn.hospital.entity.Review;
import com.lhn.hospital.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
public interface ReviewService {


    public Review addReview(Review review);


}
