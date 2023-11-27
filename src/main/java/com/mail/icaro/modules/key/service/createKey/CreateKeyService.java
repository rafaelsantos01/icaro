package com.mail.icaro.modules.key.service.createKey;

import com.mail.icaro.modules.key.entity.KeyAccess;
import com.mail.icaro.modules.key.entity.KeyAccessRepository;
import com.mail.icaro.modules.key.service.createKey.dto.CreateKeyDTO;
import com.mail.icaro.modules.key.service.createKey.dto.CreateKeyResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class CreateKeyService {

    @Autowired
    private KeyAccessRepository keyAccessRepository;

    public CreateKeyResponseDTO execute(@Valid CreateKeyDTO data){

        KeyAccess key = keyAccessRepository.findByKey(data.getAccessKey());
        if(key != null || data.getAccessKey().length() < 10){
            throw new Error("invalidKey");
        }

        KeyAccess keyAccess = new KeyAccess();
        keyAccess.setStatus(true);
        keyAccess.setService(data.getService());
        keyAccess.setKey(data.getAccessKey());

        keyAccessRepository.saveAndFlush(keyAccess);

        CreateKeyResponseDTO responseDTO = new CreateKeyResponseDTO();
        responseDTO.setKey(keyAccess.getKey());
        responseDTO.setId(keyAccess.getId());
        responseDTO.setStatus(keyAccess.getStatus());
        responseDTO.setService(keyAccess.getService());

        return responseDTO;
    }
}
