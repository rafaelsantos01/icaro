package com.mail.icaro.shared.sendEmail.service;

import com.mail.icaro.shared.sendEmail.dtos.SendEmailServiceSimpleDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.internet.MimeMessage;

@Log4j2

@Service
public class SendMailServiceSimple {

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean execute(SendEmailServiceSimpleDTO data){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(data.getUserMail());
            helper.setSubject(data.getTitle());
            helper.setText(data.getContent(), true);

            javaMailSender.send(message);

            log.info("Email enviado com sucesso");
            return true;
        }catch (Exception e){
            log.error("Error when sending simple email",e);
            return false;
        }
    }
}
