package com.lhn.hospital.service;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.lhn.hospital.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UserService extends UserDetailsService {
    User addUser(Map<String, String> params, MultipartFile avatar);

    User getUserByUsername(String username);
    boolean authenticate(String username, String password);



}
