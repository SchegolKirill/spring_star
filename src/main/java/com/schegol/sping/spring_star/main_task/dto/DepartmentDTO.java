package com.schegol.sping.spring_star.main_task.dto;


import lombok.Data;

import java.util.List;

@Data
public class DepartmentDTO {
    private String departmentName;
    private List<PersonDTO> employees;
}
