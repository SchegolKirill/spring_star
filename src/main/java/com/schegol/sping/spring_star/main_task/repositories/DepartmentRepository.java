package com.schegol.sping.spring_star.main_task.repositories;

import com.schegol.sping.spring_star.main_task.models.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
}
