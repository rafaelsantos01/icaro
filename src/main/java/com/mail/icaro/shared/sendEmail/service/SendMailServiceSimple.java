package com.mail.icaro.shared.sendEmail.service;

import com.mail.icaro.shared.sendEmail.dtos.SendEmailServiceSimpleDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

@Slf4j

@Service
@Transactional
public class SendMailServiceSimple {

    @Autowired
    private JavaMailSender javaMailSender;

    private static final Logger logger = LoggerFactory.getLogger(SendMailServiceSimple.class);

    public void SendEmailSimple(SendEmailServiceSimpleDTO data){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(data.getUserMail());
            helper.setSubject(data.getTitle());
            helper.setText(data.getContent(), true);

            javaMailSender.send(message);
        }catch (Exception e){
            logger.error("Error when sending simple email",e);
        }
    }
}
