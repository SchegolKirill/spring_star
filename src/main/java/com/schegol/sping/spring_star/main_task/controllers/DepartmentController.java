package com.schegol.sping.spring_star.main_task.controllers;

import com.schegol.sping.spring_star.main_task.converters.DepartmentConverter;
import com.schegol.sping.spring_star.main_task.dto.DepartmentDTO;
import com.schegol.sping.spring_star.main_task.models.Department;
import com.schegol.sping.spring_star.main_task.services.DepartmentService;
import com.schegol.sping.spring_star.main_task.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final PersonService personService;
    private final DepartmentService departmentService;
    private final DepartmentConverter departmentConverter;

    @GetMapping("/getall")
    public List<DepartmentDTO> getDepts(){
        return departmentConverter.entityToDTO(departmentService.getDepartments());
    }

    @PostMapping("/addnewdep")
    public String addNewDep(@RequestBody Department department){
        departmentService.addNewDepartment(department);
        return "Отдел " + department.getDepartmentName() + " успешно создан.";
    }

    @PutMapping("/adddeptopers")
    public String addDepToPers(@RequestParam("persName") String persName,
                               @RequestParam("depId") Integer depId){
        departmentService.addDepartmentToPerson(personService.getPerson(persName),
                departmentService.getDepById(depId));
        return "Человек " + persName + " добавлен в отдел " + departmentService.getDepById(depId);
    }

    @PutMapping("/deletepers")
    public String deletePers(@RequestParam("persName") String persName,
                             @RequestParam("depId") Integer depId){
        departmentService.removePersonFromDepartment(personService.getPerson(persName),
                departmentService.getDepById(depId));
        return "Человек " + persName + " успешно удален из отдела " +
                departmentService.getDepById(depId).getDepartmentName();
    }

    @DeleteMapping("/deletedep/{id}")
    public String deleteDep(@PathVariable("id") Integer id){
        String dep = departmentService.getDepById(id).getDepartmentName();
        departmentService.deleteDepartment(id);
        return "Отдел " + dep + " успешно удален.";
    }

    @GetMapping("/getdep/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentService.getDepById(id);
    }
}
