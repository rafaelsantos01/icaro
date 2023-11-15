package com.mail.icaro.modules.history.service.sendNewEmailSync;

import com.mail.icaro.modules.history.service.sendNewEmailSync.dto.SendNewEmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@EnableKafka
public class SendNewEmailSyncListener {

    @Autowired
    SendNewEmailSyncService service;


    @KafkaListener(topics = "sendEmailSync",containerFactory = "ContainerFactory")
    public void handle(@Payload SendNewEmailDTO data){
        service.execute(data);
    }
}
