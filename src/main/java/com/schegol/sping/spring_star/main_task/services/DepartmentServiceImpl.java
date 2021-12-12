package com.schegol.sping.spring_star.main_task.services;

import com.schegol.sping.spring_star.main_task.models.Department;
import com.schegol.sping.spring_star.main_task.models.Person;
import com.schegol.sping.spring_star.main_task.repositories.DepartmentRepository;
import com.schegol.sping.spring_star.main_task.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;
    private final PersonRepository personRepository;

    @Override
    public List<Department> getDepartments() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public Department getDepById(Integer id){
        return departmentRepository.findById(id).get();
    }

    @Override
    public void addNewDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void addDepartmentToPerson(Person person, Department department) {
        personRepository.findById(person.getId()).get().
                setDepartment(departmentRepository.findById(department.getId()).get());
    }

    @Override
    public void removePersonFromDepartment(Person person, Department department) {
        departmentRepository.findById(department.getId()).get().getPersonList().remove(person);
    }

    @Override
    public void deleteDepartment(Integer id) {
        Department dep = this.getDepById(id);
        departmentRepository.delete(dep);
    }
}
