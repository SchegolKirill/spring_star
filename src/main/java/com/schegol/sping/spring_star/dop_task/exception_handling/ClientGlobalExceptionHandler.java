package com.schegol.sping.spring_star.dop_task.exception_handling;

import com.schegol.sping.spring_star.main_task.exception_handling.ExceptionVariant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClientGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(ClientException clientException){
        IncorrectData data = new IncorrectData();
        data.setInfo(ExceptionVariant.NOT_FOUND.getAdvice());
        return new ResponseEntity<> (data, HttpStatus.NOT_FOUND);
    }
}
