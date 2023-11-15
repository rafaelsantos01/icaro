package com.mail.icaro.shared.sendEmail.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SendEmailServiceSimpleDTO {

    @NotNull @NotBlank @NotEmpty
    private String userMail;

    @NotNull @NotBlank @NotEmpty
    private String title;

    @NotNull @NotBlank @NotEmpty
    private String content;

}
