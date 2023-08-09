package com.ai.ats.service;

import com.ai.ats.dto.Hiring;
import com.ai.ats.exception.EmailCantSendException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HiringService {

    private JavaMailSender javaMailSender;

    @Autowired
    public HiringService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendBulkHiringMail(List<Hiring> hirings) {

        for (Hiring hiring : hirings) {

                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                simpleMailMessage.setFrom(hiring.getSenderEmail());
                simpleMailMessage.setTo(hiring.getCandidateEmail());
                simpleMailMessage.setText(hiring.getCandidateJobDescription());
                simpleMailMessage.setSubject(hiring.getCandidateSubject());
            try {
                javaMailSender.send(simpleMailMessage);
            }catch (MailException e){
                throw new EmailCantSendException("Email not send to " + hiring.getCandidateEmail());
            }
        }
    }

}
