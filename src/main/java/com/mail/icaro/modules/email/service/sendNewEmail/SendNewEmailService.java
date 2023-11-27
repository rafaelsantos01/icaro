package com.mail.icaro.modules.email.service.sendNewEmail;

import com.mail.icaro.modules.email.service.sendNewEmail.dto.SendNewEmailDTO;
import com.mail.icaro.shared.sendEmail.dtos.SendEmailServiceSimpleDTO;
import com.mail.icaro.shared.sendEmail.service.SendMailServiceSimple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class SendNewEmailService {

    @Autowired
    private SendMailServiceSimple sendMailServiceSimple;

    public SendNewEmailDTO execute(@Valid SendNewEmailDTO data){
        SendEmailServiceSimpleDTO sendEmailServiceSimpleDTO = new SendEmailServiceSimpleDTO();
        sendEmailServiceSimpleDTO.setContent(data.getContent());
        sendEmailServiceSimpleDTO.setTitle(data.getTitle());
        sendEmailServiceSimpleDTO.setUserMail(data.getUserMail());

        boolean execute = sendMailServiceSimple.execute(sendEmailServiceSimpleDTO);
        if(!execute){
            throw new Error("errorSendEmail");
        }

        SendNewEmailDTO response = new SendNewEmailDTO();
        response.setContent(data.getContent());
        response.setTitle(data.getTitle());
        response.setUserMail(data.getUserMail());

        return response;
    }
}
