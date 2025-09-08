package com.lhn.hospital.repository;


import com.lhn.hospital.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {


    List<Review> findByDoctor_Id(Integer doctorId);
}
