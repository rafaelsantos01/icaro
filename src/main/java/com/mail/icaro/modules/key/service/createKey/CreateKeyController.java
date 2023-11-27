package com.mail.icaro.modules.key.service.createKey;

import com.mail.icaro.modules.key.service.createKey.dto.CreateKeyDTO;
import com.mail.icaro.modules.key.service.createKey.dto.CreateKeyResponseDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Key")
@RestController
@RequestMapping("/api/icaro/key")
public class CreateKeyController {

    @Autowired
    private CreateKeyService service;


    @ApiOperation(value = "Endpoint responsável por criar uma chave de acesso.",
            notes = "")
    @Tag(name = "Key")
    @PostMapping
    @ResponseBody
    public ResponseEntity<CreateKeyResponseDTO> handle(@RequestBody @Valid CreateKeyDTO data){
        CreateKeyResponseDTO execute = service.execute(data);
        return new ResponseEntity<>(execute, HttpStatus.CREATED);
    }
}
