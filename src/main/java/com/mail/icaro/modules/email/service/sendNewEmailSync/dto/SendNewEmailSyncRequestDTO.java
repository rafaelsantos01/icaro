package com.mail.icaro.modules.email.service.sendNewEmailSync.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SendNewEmailSyncRequestDTO {

    @NotNull
    @NotBlank
    @NotEmpty
    @Email
    private String userMail;

    @NotNull
    @NotBlank
    @NotEmpty
    private String title;

    @NotNull
    @NotBlank
    @NotEmpty
    private String content;
}
