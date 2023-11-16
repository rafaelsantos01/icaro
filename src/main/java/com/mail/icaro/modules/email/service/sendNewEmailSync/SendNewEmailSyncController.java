package com.mail.icaro.modules.email.service.sendNewEmailSync;

import com.mail.icaro.modules.email.service.sendNewEmail.dto.SendNewEmailDTO;
import com.mail.icaro.modules.email.service.sendNewEmailSync.dto.SendNewEmailSyncRequestDTO;
import com.mail.icaro.modules.email.service.sendNewEmailSync.dto.SendNewEmailSyncResponseDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Email")
@RestController
@RequestMapping("/api/icaro/sync/sendEmail")
public class SendNewEmailSyncController {

    @Autowired
    SendNewEmailSyncService service;


    @ApiOperation(value = "Endpoint responsável por salvar um email no banco, e posteriormente enviar.",notes = "")
    @Tag(name = "Email")
    @PostMapping
    @ResponseBody
    public ResponseEntity<SendNewEmailSyncResponseDTO> handle(@RequestBody @Valid SendNewEmailSyncRequestDTO data){

        SendNewEmailSyncResponseDTO execute = service.execute(data);

        return new ResponseEntity<>(execute, HttpStatus.CREATED);
    }
}
