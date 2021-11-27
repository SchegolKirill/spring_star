package com.schegol.sping.spring_star.repositories;

import com.schegol.sping.spring_star.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //вроде необязательно эту аннотацию
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
