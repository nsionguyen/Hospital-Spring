package com.lhn.hospital.controller;


import com.lhn.hospital.dto.request.UserDTO;
import com.lhn.hospital.entity.User;
import com.lhn.hospital.service.UserService;
import com.lhn.hospital.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping(path = "/users",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestParam Map<String, String> params, @RequestParam(value = "avatar") MultipartFile avatar) {
        return new ResponseEntity<>(this.userService.addUser(params, avatar), HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO u) {
        System.out.println(">>> Đang xử lý login cho username: " + u.getUsername());

        if (userService.authenticate(u.getUsername(), u.getPassword())) {
            try {
                String token = JwtUtils.generateToken(u.getUsername());
                System.out.println(">>> Token đã được tạo thành công cho user: " + u.getUsername());
                return ResponseEntity.ok()
                        .body(Collections.singletonMap("token", token));
            } catch (Exception e) {
                System.err.println(">>> Lỗi khi tạo token: " + e.getMessage());
                return ResponseEntity.status(500).body("Lỗi khi tạo JWT");
            }
        }

        System.out.println(">>> Sai thông tin đăng nhập cho username: " + u.getUsername());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Sai thông tin đăng nhập");
    }

    @RequestMapping("/secure/profile")
    public ResponseEntity<User> getProfile(Principal principal) {
        return new ResponseEntity<>(this.userService.getUserByUsername(principal.getName()), HttpStatus.OK);
    }



}
