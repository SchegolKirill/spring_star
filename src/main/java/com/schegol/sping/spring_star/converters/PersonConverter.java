package com.schegol.sping.spring_star.converters;

import com.schegol.sping.spring_star.dto.PersonDTO;
import com.schegol.sping.spring_star.models.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonConverter {
    public PersonDTO entityToDTO(Person person){

        PersonDTO dto = new PersonDTO();
        dto.setName(person.getName());
        dto.setSurname(person.getSurname());
        dto.setPatronymic(person.getPatronymic());
        dto.setAge(person.getAge());

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

        return p;
    }

    public List<Person> DTOToEntity(List<PersonDTO> dto){
        return dto.stream().map(x -> DTOToEntity(x)).collect(Collectors.toList());
    }
}
