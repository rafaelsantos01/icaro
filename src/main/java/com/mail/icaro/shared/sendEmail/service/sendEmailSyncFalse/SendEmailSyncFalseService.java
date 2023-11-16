package com.mail.icaro.shared.sendEmail.service.sendEmailSyncFalse;


import com.mail.icaro.modules.history.entity.ShippingHistory;
import com.mail.icaro.modules.history.repository.ShippingHistoryRepository;
import com.mail.icaro.shared.sendEmail.dtos.SendEmailServiceSimpleDTO;
import com.mail.icaro.shared.sendEmail.service.SendMailServiceSimple;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Log4j2
@Service
public class SendEmailSyncFalseService {

    @Autowired
    ShippingHistoryRepository shippingHistoryRepository;

    @Autowired
    SendMailServiceSimple sendMailServiceSimple;

    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    public SendEmailSyncFalseService() {

        scheduler = Executors.newScheduledThreadPool(1);
        int initialDelay = 1;
        int period = 5;
        TimeUnit unit = TimeUnit.MINUTES;
        scheduler.scheduleAtFixedRate(this::execute, initialDelay, period, unit);
    }

    public void execute(){
        log.info("Checking unsynchronised emails");
        List<ShippingHistory> bySyncFalse = shippingHistoryRepository.findBySyncFalseAndFailSendNull();

        for(ShippingHistory shippingHistory: bySyncFalse){
            SendEmailServiceSimpleDTO data = new SendEmailServiceSimpleDTO();
            data.setUserMail(shippingHistory.getUserMail());
            data.setContent(shippingHistory.getContent());
            data.setTitle(shippingHistory.getTitle());

            boolean sync = sendMailServiceSimple.execute(data);

            shippingHistory.setFailSend(!sync);
            shippingHistory.setSync(sync);
            shippingHistoryRepository.saveAndFlush(shippingHistory);
        }
    }
}
