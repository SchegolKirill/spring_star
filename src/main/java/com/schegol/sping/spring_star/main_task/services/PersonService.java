package com.schegol.sping.spring_star.main_task.services;

import com.schegol.sping.spring_star.main_task.models.Person;

import java.util.List;

public interface PersonService {

    Person getPerson(String name);

    void updatePerson(Integer id, Integer age);

    void deletePerson(Integer id);

    List<Person> getPersonSameAge(Integer age);

    void addPerson(Person person);

    List<Person> getPersonOver30();

    void addPersons(List<Person> persons);
}