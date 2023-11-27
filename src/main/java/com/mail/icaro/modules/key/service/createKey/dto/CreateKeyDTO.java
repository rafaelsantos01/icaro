package com.mail.icaro.modules.key.service.createKey.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateKeyDTO {

    @NotNull @NotEmpty @NotBlank
    private String service;

    @NotNull @NotEmpty @NotBlank
    private String accessKey;

}
