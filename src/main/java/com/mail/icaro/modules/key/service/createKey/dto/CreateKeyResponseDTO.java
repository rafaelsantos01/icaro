package com.mail.icaro.modules.key.service.createKey.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateKeyResponseDTO {

    private UUID id;

    private String service;

    private String key;

    private Boolean status;
}
