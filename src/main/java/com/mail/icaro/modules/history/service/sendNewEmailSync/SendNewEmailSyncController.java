package com.mail.icaro.modules.history.service.sendNewEmailSync;

import com.mail.icaro.modules.history.service.sendNewEmailSync.dto.SendNewEmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/icaro/sync/sendEmail")
public class SendNewEmailSyncController {

    @Autowired
    SendNewEmailSyncService service;


    @PostMapping
    @ResponseBody
    public ResponseEntity<Void> handle(@RequestBody @Valid SendNewEmailDTO data){
        service.execute(data);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
