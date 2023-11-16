package com.mail.icaro.modules.email.service.sendNewEmailSync.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class SendNewEmailSyncResponseDTO {

    private String userMail;

    private String title;

    private String content;

    private UUID id;

    private boolean sync;

}
