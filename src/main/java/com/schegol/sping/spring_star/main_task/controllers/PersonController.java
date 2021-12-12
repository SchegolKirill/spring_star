package com.schegol.sping.spring_star.main_task.controllers;

import com.schegol.sping.spring_star.main_task.converters.PassportConverter;
import com.schegol.sping.spring_star.main_task.converters.PersonConverter;
import com.schegol.sping.spring_star.main_task.dto.PersonDTO;
import com.schegol.sping.spring_star.main_task.exception_handling.ExceptionVariant;
import com.schegol.sping.spring_star.main_task.exception_handling.PersonException;
import com.schegol.sping.spring_star.main_task.models.Person;
import com.schegol.sping.spring_star.main_task.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final PersonConverter personConverter;
    private final PassportConverter passportConverter;

    @GetMapping("/{name}")
    public Person getPerson(@PathVariable String name){
        if(personService.getPerson(name) == null){
            throw new PersonException(ExceptionVariant.NOT_FOUND.getAdvice());
        }
        return personService.getPerson(name);
    }

    @PutMapping("/updatebyrp/{id}")
    public String updatePersonByRequestParam(@PathVariable Integer id,
                               @RequestParam Integer age){
        personService.updatePerson(id, age);
        return "Человек с id " + " успешно обнавлен.";
    }

    @PutMapping("/updatebyrb/{id}")
    public String updatePersonByRequestBody(@PathVariable Integer id,
                                            @RequestBody Person person){
        personService.updatePerson(id, person.getAge());
        return "Человек с id " + " успешно обнавлен.";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable Integer id){
        personService.deletePerson(id);
        return "Человек с id " + " успешно удален.";
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

    @PostMapping("/addperson")
    public String addNewPerson(@RequestBody Person person){
        personService.addPerson(person);
        return "Новый человек успешно добавлен." ;
    }

    @GetMapping("/over30")
    public List<PersonDTO> getPersonOver30(){
        return personConverter.entityToDTO(personService.getPersonOver30());
    }

    @PostMapping("/addpersons")
    public String addNewPersons(@RequestBody List<Person> persons){
        personService.addPersons(persons);
        return "Список людей успешно добавлен";
    }
}
