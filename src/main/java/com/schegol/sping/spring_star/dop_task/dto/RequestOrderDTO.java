package com.schegol.sping.spring_star.dop_task.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestOrderDTO {
    private Integer number;
    private LocalDate dateOfCreation;
    private String description;
    private Long sum;
    private Integer id;
}
