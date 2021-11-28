package com.schegol.sping.spring_star.services;

import com.schegol.sping.spring_star.dto.PersonDTO;
import com.schegol.sping.spring_star.models.Person;

import java.util.List;

public interface PersonService {

    Person getPerson(String name);

    Person updatePerson(Integer id, Integer age);

    String deletePerson(Integer id);

    List<Person> getPersonSameAge(Integer age);

    String addPerson(Person person);

    List<Person> getPersonOver30();
}