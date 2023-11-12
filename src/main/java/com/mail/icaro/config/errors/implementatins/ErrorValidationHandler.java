package com.mail.icaro.config.errors.implementatins;

import com.mail.icaro.config.errors.implementatins.dto.ErrorValidadeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ErrorValidationHandler {

  @Autowired
  private MessageSource messageSource;



  @ExceptionHandler({MethodArgumentNotValidException.class})
  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ResponseBody
  public List<ErrorValidadeDTO> handle (MethodArgumentNotValidException exception){
    List<ErrorValidadeDTO> errors = new ArrayList<>();

    List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

    fieldErrors.forEach(exc -> {
      String message = messageSource.getMessage(exc, LocaleContextHolder.getLocale());

      ErrorValidadeDTO error = new ErrorValidadeDTO(exc.getField(),message);

      errors.add(error);

    });

    return errors;

  }
}
