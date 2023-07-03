package com.exceptions;

import com.utils.TransactionStatus;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.LoggerFactory;
import org.springframework.core.NestedCheckedException;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.SQLExceptionSubclassTranslator;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

@ControllerAdvice
public class ControllerAdviceHandler {


    @ExceptionHandler
    public ModelAndView handleDuplicateDataException(DataIntegrityViolationException e){
        String message = e.getMessage();
        String newMessage = message.substring(message.lastIndexOf("Key")+5).replaceAll("[(){}]","");
        String field=newMessage.substring(newMessage.indexOf("=")+1,newMessage.indexOf("already"));
        String description = newMessage.substring(newMessage.indexOf(" "));
        String customMessage =field+description;

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signup");
        modelAndView.addObject("error",customMessage);

//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customMessage);
        return modelAndView;

    }

}
