package com.lhn.hospital.repository;


import com.lhn.hospital.entity.Hospital;
import com.lhn.hospital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(int id);
    User findByUsername(String username);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
