package com.schegol.sping.spring_star.dop_task.exception_handling;

public enum ClientExceptionVariant {
    NOT_FOUND("Данный клиент не найден"), BAD_REQUEST("Некорректный запрос");

    private String advice;

    ClientExceptionVariant(String advice){
        this.advice = advice;
    }

    public String getAdvice(){
        return advice;
    }
}
