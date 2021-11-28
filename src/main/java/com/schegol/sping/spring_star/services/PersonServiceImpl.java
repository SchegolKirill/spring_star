package com.schegol.sping.spring_star.services;

import com.schegol.sping.spring_star.models.Person;
import com.schegol.sping.spring_star.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{


    private final PersonRepository personRepository;

    @Override
    public Person getPerson(String name) {
        for(Person person : personRepository.findAll()){
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

    @Override
    public Person updatePerson(Integer id, Integer age) {
        personRepository.findById(id).get().setAge(age);
        return personRepository.findById(id).get();
    }

    @Override
    public String deletePerson(Integer id) {
        personRepository.deleteById(id);
        return "Person с id " + id + " успешно удалён.";
    }

    @Override
    public List<Person> getPersonSameAge(Integer age){
        List<Person> personList = new ArrayList<>();
        for(Person person : personRepository.findAll()){
            if(person.getAge().equals(age)){
                personList.add(person);
            }
        }
        return personList;
    }

    @Override
    public String addPerson(Person person) {
        personRepository.save(person);
        return "Новый Person успешно добавлен." ;
    }

    @Override
    public List<Person> getPersonOver30() {
        return personRepository.findByAgeGreaterThan30();
    }
}
