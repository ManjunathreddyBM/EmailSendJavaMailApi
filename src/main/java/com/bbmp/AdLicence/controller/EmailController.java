package com.bbmp.AdLicence.controller;

import com.bbmp.AdLicence.model.EmailTemplate;
import com.bbmp.AdLicence.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
@Slf4j
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody EmailTemplate emailTemplate) {
        log.info("Sending email template: {}", emailTemplate);
        return emailService.sendMail(emailTemplate.getToEmail(), emailTemplate.getSubject(), emailTemplate.getContent());
    }
}
