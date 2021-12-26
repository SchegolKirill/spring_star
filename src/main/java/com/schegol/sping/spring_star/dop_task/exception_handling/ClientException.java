package com.schegol.sping.spring_star.dop_task.exception_handling;

public class ClientException extends RuntimeException{

    private ClientExceptionVariant variant;

    public ClientException(ClientExceptionVariant variant){
        super(variant.getAdvice());
    }
}
