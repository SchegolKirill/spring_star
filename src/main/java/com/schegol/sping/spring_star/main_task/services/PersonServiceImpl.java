package com.schegol.sping.spring_star.main_task.services;

import com.schegol.sping.spring_star.main_task.models.Person;
import com.schegol.sping.spring_star.main_task.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{


    private final PersonRepository personRepository;

    @Override
    public Person getPerson(String name) {
//        for(Person person : personRepository.findAll()){
//            if(person.getName().equals(name)){
//                return person;
//            }
//        }
//        return null;
        return personRepository.findByName(name);
    }

    @Override
    public void updatePerson(Integer id, Integer age) {
        personRepository.findById(id).get().setAge(age);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> getPersonSameAge(Integer age){
//        List<Person> personList = new ArrayList<>();
//        for(Person person : personRepository.findAll()){
//            if(person.getAge().equals(age)){
//                personList.add(person);
//            }
//        }
        return personRepository.findByAge(age);


    }

    @Override
    public void addPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public List<Person> getPersonOver30() {
        return personRepository.findByAgeGreaterThan(30);
    }

    public void addPersons(List<Person> persons){
        for(Person person : persons){
            personRepository.save(person);
        }
    }
}
