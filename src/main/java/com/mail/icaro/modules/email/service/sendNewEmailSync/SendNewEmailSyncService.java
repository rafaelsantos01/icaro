package com.mail.icaro.modules.email.service.sendNewEmailSync;

import com.mail.icaro.modules.email.service.sendNewEmailSync.dto.SendNewEmailSyncRequestDTO;
import com.mail.icaro.modules.email.service.sendNewEmailSync.dto.SendNewEmailSyncResponseDTO;
import com.mail.icaro.modules.history.entity.ShippingHistory;
import com.mail.icaro.modules.history.repository.ShippingHistoryRepository;
import com.mail.icaro.modules.email.service.sendNewEmail.dto.SendNewEmailDTO;
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

    public SendNewEmailSyncResponseDTO execute(SendNewEmailSyncRequestDTO data){

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

        SendNewEmailSyncResponseDTO sendNewEmailSyncResponseDTO = new SendNewEmailSyncResponseDTO();
        sendNewEmailSyncResponseDTO.setContent(shippingHistory.getContent());
        sendNewEmailSyncResponseDTO.setTitle(shippingHistory.getTitle());
        sendNewEmailSyncResponseDTO.setUserMail(shippingHistory.getUserMail());
        sendNewEmailSyncResponseDTO.setId(shippingHistory.getId());
        sendNewEmailSyncResponseDTO.setSync(shippingHistory.getSync());

        return sendNewEmailSyncResponseDTO;
    }
}
