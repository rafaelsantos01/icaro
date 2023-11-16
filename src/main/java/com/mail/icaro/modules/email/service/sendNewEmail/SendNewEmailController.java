package com.mail.icaro.modules.email.service.sendNewEmail;

import com.mail.icaro.modules.email.service.sendNewEmail.dto.SendNewEmailDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Email")
@RestController
@RequestMapping("/api/icaro/sendEmail")
public class SendNewEmailController {

    @Autowired
    SendNewEmailService service;


    @ApiOperation(value = "Endpoint responsável por enviar email.", notes = "")
    @Tag(name = "Email")
    @PostMapping
    @ResponseBody
    public ResponseEntity<SendNewEmailDTO> handle(@RequestBody @Valid SendNewEmailDTO data){

        SendNewEmailDTO execute = service.execute(data);

        return new ResponseEntity<>(execute,HttpStatus.ACCEPTED);
    }
}
