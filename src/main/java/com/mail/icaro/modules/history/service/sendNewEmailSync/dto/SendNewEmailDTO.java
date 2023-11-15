package com.mail.icaro.modules.history.service.sendNewEmailSync.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SendNewEmailDTO {

    @NotNull
    @NotBlank
    @NotEmpty
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
