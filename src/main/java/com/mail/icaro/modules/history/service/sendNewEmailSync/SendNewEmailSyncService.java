package com.mail.icaro.modules.history.service.sendNewEmailSync;

import com.mail.icaro.modules.history.entity.ShippingHistory;
import com.mail.icaro.modules.history.repository.ShippingHistoryRepository;
import com.mail.icaro.modules.history.service.sendNewEmailSync.dto.SendNewEmailDTO;
import com.mail.icaro.shared.sendEmail.dtos.SendEmailServiceSimpleDTO;
import com.mail.icaro.shared.sendEmail.service.SendMailServiceSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendNewEmailSyncService {

    @Autowired
    ShippingHistoryRepository shippingHistoryRepository;

    @Autowired
    SendMailServiceSimple sendMailServiceSimple;

    public void execute(SendNewEmailDTO data){

        ShippingHistory shippingHistory = new ShippingHistory();
        shippingHistory.setContent(data.getContent());
        shippingHistory.setTitle(data.getTitle());
        shippingHistory.setUserMail(data.getUserMail());

        SendEmailServiceSimpleDTO sendEmailServiceSimpleDTO = new SendEmailServiceSimpleDTO();
        sendEmailServiceSimpleDTO.setContent(data.getContent());
        sendEmailServiceSimpleDTO.setTitle(data.getTitle());
        sendEmailServiceSimpleDTO.setUserMail(data.getUserMail());
        boolean sync = sendMailServiceSimple.execute(sendEmailServiceSimpleDTO);

        shippingHistory.setSync(sync);
        shippingHistoryRepository.saveAndFlush(shippingHistory);
    }
}
