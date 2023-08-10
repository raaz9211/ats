package com.ai.ats.service;

import com.ai.ats.dto.HiringDTO;
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

    public void sendBulkHiringMail(List<HiringDTO> hiringDTOS) {

        for (HiringDTO hiringDTO : hiringDTOS) {

                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                simpleMailMessage.setFrom(hiringDTO.getSenderEmail());
                simpleMailMessage.setTo(hiringDTO.getCandidateEmail());
                simpleMailMessage.setText(hiringDTO.getCandidateJobDescription());
                simpleMailMessage.setSubject(hiringDTO.getCandidateSubject());
            try {
                javaMailSender.send(simpleMailMessage);
            }catch (MailException e){
                throw new EmailCantSendException("Email not send to " + hiringDTO.getCandidateEmail());
            }
        }
    }

}
