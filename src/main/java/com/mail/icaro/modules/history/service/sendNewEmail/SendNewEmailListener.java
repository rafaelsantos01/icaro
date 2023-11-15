package com.mail.icaro.modules.history.service.sendNewEmail;

import com.mail.icaro.modules.history.service.sendNewEmailSync.dto.SendNewEmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@EnableKafka
public class SendNewEmailListener {

    @Autowired
    SendNewEmailService service;

    @KafkaListener(topics = "sendEmail",containerFactory = "ContainerFactory")
    public void handle(@Payload SendNewEmailDTO data){
        service.execute(data);
    }
}
