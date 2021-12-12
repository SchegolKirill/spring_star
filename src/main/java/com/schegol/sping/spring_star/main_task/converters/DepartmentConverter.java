package com.schegol.sping.spring_star.main_task.converters;

import com.schegol.sping.spring_star.main_task.dto.DepartmentDTO;
import com.schegol.sping.spring_star.main_task.models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentConverter {

    @Autowired
    PersonConverter personConverter;

    public DepartmentDTO entityToDTO(Department department){
        DepartmentDTO dto = new DepartmentDTO();
        dto.setDepartmentName(department.getDepartmentName());
        dto.setEmployees(personConverter.entityToDTO(department.getPersonList()));
        return dto;
    }

    public List<DepartmentDTO> entityToDTO(List<Department> departments){
        return departments.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public Department DTOToEntity(DepartmentDTO dto){
        Department department = new Department();
        department.setDepartmentName(dto.getDepartmentName());
        department.setPersonList(personConverter.DTOToEntity(dto.getEmployees()));
        return department;
    }

    public List<Department> DTOtoEntity(List<DepartmentDTO> dto){
        return dto.stream().map(x -> DTOToEntity(x)).collect(Collectors.toList());
    }
}
