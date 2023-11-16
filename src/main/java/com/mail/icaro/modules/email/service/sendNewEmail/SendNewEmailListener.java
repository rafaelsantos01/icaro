package com.mail.icaro.modules.email.service.sendNewEmail;

import com.mail.icaro.modules.email.service.sendNewEmail.dto.SendNewEmailDTO;
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

    @KafkaListener(topics = "${app.topic.kafka.send-new-email}",containerFactory = "ContainerFactory")
    public void handle(@Payload SendNewEmailDTO data){
        service.execute(data);
    }
}
