package com.lhn.hospital.controller;


import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.lhn.hospital.dto.response.ResponseData;
import com.lhn.hospital.dto.response.ResponseError;
import com.lhn.hospital.service.MailService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;

@Slf4j
@RestController
@RequestMapping("/api/common")
public record CommonController (MailService mailService) {
    @PostMapping("/send-email")
    public ResponseData<?> sendEmail(@RequestParam String recipients, @RequestParam String subject,
                                     @RequestParam String content, @RequestParam(required = false) MultipartFile[] files) {
        log.info("Request GET /common/send-email");
        try {
            return new ResponseData(ACCEPTED.value(), mailService.sendEmail(recipients, subject, content, files));
        } catch (UnsupportedEncodingException | MessagingException e) {
            log.error("Sending email was failure, message={}", e.getMessage(), e);
            return new ResponseError(BAD_REQUEST.value(), "Sending email was failure");
        }
    }


}
