package com.schegol.sping.spring_star.main_task.repositories;

import com.schegol.sping.spring_star.main_task.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //вроде необязательно эту аннотацию
public interface PersonRepository extends CrudRepository<Person, Integer> {

//    @Query(value = "SELECT p FROM Person p WHERE p.age > 30")
//    List<Person> findByAgeGreaterThan30();
    List<Person> findByAgeGreaterThan(Integer age);


    Person findByName(String name);

    List<Person> findByAge(Integer age);
}
