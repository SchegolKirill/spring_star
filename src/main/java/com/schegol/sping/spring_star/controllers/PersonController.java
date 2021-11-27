package com.schegol.sping.spring_star.controllers;

import com.schegol.sping.spring_star.repositories.PersonRepository;
import com.schegol.sping.spring_star.models.Person;
import com.schegol.sping.spring_star.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{name}")
    public Person getPerson(@PathVariable String name){
        return personService.getPerson(name);
    }

    @PutMapping("/updatebyrp/{id}")
    public Person updatePersonByRequestParam(@PathVariable Integer id,
                               @RequestParam Integer age){
        return personService.updatePerson(id, age);
    }

    @PutMapping("/updatebyrb/{id}")
    public Person updatePersonByRequestBody(@PathVariable Integer id, @RequestBody Person person){
        return personService.updatePerson(id, person.getAge());
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable Integer id){
        return personService.deletePerson(id);
    }

    @GetMapping("/getbyage/{age}")
    public List<Person> getPersonSameAge(@PathVariable Integer age){
        return personService.getPersonSameAge(age);
    }

    @GetMapping("/getbynameandage")
    public Person getPersonByNameAndAge(@RequestParam("name") String name,
                                        @RequestParam("age") Integer age){
        for(Person person : personService.getPersonSameAge(age)){
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

    @PostMapping("/add")
    public String addNewPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }
}
