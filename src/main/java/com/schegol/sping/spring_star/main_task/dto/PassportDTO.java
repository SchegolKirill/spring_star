package com.schegol.sping.spring_star.main_task.dto;

import lombok.*;

import java.time.LocalDate;

@Data
public class PassportDTO {

    private String series;
    private String number;
    private LocalDate dateOfIssue;
}
