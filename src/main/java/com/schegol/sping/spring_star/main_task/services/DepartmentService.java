package com.schegol.sping.spring_star.main_task.services;

import com.schegol.sping.spring_star.main_task.models.Department;
import com.schegol.sping.spring_star.main_task.models.Person;

import java.util.List;

public interface DepartmentService {
    Department getDepById(Integer id);
    List<Department> getDepartments();
    void addNewDepartment(Department department);
    void addDepartmentToPerson(Person person, Department department);
    void removePersonFromDepartment(Person person, Department department);
    void deleteDepartment(Integer id);
}
