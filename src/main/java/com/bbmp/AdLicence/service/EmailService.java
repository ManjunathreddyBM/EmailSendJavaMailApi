package com.bbmp.AdLicence.service;

import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTML;
import java.util.Properties;

@Service
@RequiredArgsConstructor
@Data
@Slf4j
public class EmailService {

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Value("${spring.mail.password}")
    private String password;

    private final JavaMailSender javaMailSender;

    public String sendMail(String to, String subject, String text) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true); // Set to true to indicate that this is an HTML email
            log.info("sending email to {}",to);
            javaMailSender.send(mimeMessage);
            log.info("Email sent");
            return "Email has been sent to " + to;
        } catch (MessagingException e) {
            log.info("Error sending email to {}: {}", to, e.getMessage());
            return "Error sending email: " + e.getMessage();
        }
    }
}
