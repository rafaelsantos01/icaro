package com.mail.icaro.modules.email.service.sendNewEmailSync;

import com.mail.icaro.modules.email.service.sendNewEmailSync.dto.SendNewEmailSyncRequestDTO;
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


    //@KafkaListener(topics = "${app.topic.kafka.send-new-email-sync}",containerFactory = "ContainerFactory")
    public void handle(@Payload SendNewEmailSyncRequestDTO data){
        service.execute(data);
    }
}
