package com.schegol.sping.spring_star.main_task.converters;

import com.schegol.sping.spring_star.main_task.dto.PersonDTO;
import com.schegol.sping.spring_star.main_task.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonConverter {

    @Autowired
    PassportConverter passportConverter;

    public PersonDTO entityToDTO(Person person){

        PersonDTO dto = new PersonDTO();
        dto.setName(person.getName());
        dto.setSurname(person.getSurname());
        dto.setPatronymic(person.getPatronymic());
        dto.setAge(person.getAge());
        dto.setPassport(passportConverter.entityToDTO(person.getPassport()));

        return dto;
    }

    public List<PersonDTO> entityToDTO(List<Person> person){
        return person.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public Person DTOToEntity(PersonDTO dto){

        Person p = new Person();
        p.setName(dto.getName());
        p.setSurname(dto.getSurname());
        p.setPatronymic(dto.getPatronymic());
        p.setAge(dto.getAge());
        p.setPassport(passportConverter.DTOtoEntity(dto.getPassport()));

        return p;
    }

    public List<Person> DTOToEntity(List<PersonDTO> dto){
        return dto.stream().map(x -> DTOToEntity(x)).collect(Collectors.toList());
    }
}
