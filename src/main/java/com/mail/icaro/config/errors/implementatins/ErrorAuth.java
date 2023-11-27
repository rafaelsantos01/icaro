package com.mail.icaro.config.errors.implementatins;

import com.mail.icaro.config.errors.implementatins.dto.ErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.context.i18n.LocaleContextHolder;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ErrorAuth {

    @Autowired
    private MessageSource messageSource;

    public void ErrorKey(HttpServletResponse response) throws ServletException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        String message = messageSource.getMessage(
                "errorKey",
                null,
                LocaleContextHolder.getLocale());

        ErrorDTO errorAuthDTO = new ErrorDTO(message);

        String json = objectMapper.writeValueAsString(errorAuthDTO);

        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(json);
        response.getWriter().flush();
    }

    public void ErrorAuth(HttpServletResponse response) throws ServletException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        String message = messageSource.getMessage(
                "errorKey",
                null,
                LocaleContextHolder.getLocale());

        ErrorDTO errorAuthDTO = new ErrorDTO(message);

        String json = objectMapper.writeValueAsString(errorAuthDTO);

        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(json);
        response.getWriter().flush();
    }
}
