package com.lhn.hospital.service.impl;

import com.lhn.hospital.entity.Review;
import com.lhn.hospital.repository.ReviewRepository;
import com.lhn.hospital.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }
}
