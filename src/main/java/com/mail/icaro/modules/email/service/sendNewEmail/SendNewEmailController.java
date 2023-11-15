package com.mail.icaro.modules.email.service.sendNewEmail;

import com.mail.icaro.modules.email.service.sendNewEmailSync.dto.SendNewEmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/icaro/sendEmail")
public class SendNewEmailController {

    @Autowired
    SendNewEmailService service;


    @PostMapping
    @ResponseBody
    public ResponseEntity<Boolean> handle(@RequestBody @Valid SendNewEmailDTO data){
        boolean execute = service.execute(data);

        return new ResponseEntity<>(execute,HttpStatus.ACCEPTED);
    }
}
