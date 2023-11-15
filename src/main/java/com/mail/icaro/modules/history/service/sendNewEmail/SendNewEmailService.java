package com.mail.icaro.modules.history.service.sendNewEmail;

import com.mail.icaro.modules.history.entity.ShippingHistory;
import com.mail.icaro.modules.history.repository.ShippingHistoryRepository;
import com.mail.icaro.modules.history.service.sendNewEmailSync.dto.SendNewEmailDTO;
import com.mail.icaro.shared.sendEmail.dtos.SendEmailServiceSimpleDTO;
import com.mail.icaro.shared.sendEmail.service.SendMailServiceSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class SendNewEmailService {

    @Autowired
    SendMailServiceSimple sendMailServiceSimple;

    public boolean execute(@Valid SendNewEmailDTO data){
        SendEmailServiceSimpleDTO sendEmailServiceSimpleDTO = new SendEmailServiceSimpleDTO();
        sendEmailServiceSimpleDTO.setContent(data.getContent());
        sendEmailServiceSimpleDTO.setTitle(data.getTitle());
        sendEmailServiceSimpleDTO.setUserMail(data.getUserMail());

        return sendMailServiceSimple.execute(sendEmailServiceSimpleDTO);
    }
}
