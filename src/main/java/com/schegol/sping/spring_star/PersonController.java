package com.schegol.sping.spring_star;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private List<Person> persons = new ArrayList<>();

    {
        persons.add(new Person("john", 20));
        persons.add(new Person("joanna", 24));
        persons.add(new Person("bred", 50));
        persons.add(new Person("kate", 33));
    }



    @GetMapping("/rp")
    public Person getPersonByRequestParam(@RequestParam("name") String name,
                                          @RequestParam("age") Integer age){
        for(Person person : persons){
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

    @GetMapping("/pv/{name}")
    public Person getPersonByPathVariable(@PathVariable String name){
        for(Person person : persons){
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

    @GetMapping("/rb")
    public Person getPersonByResponseBody(@RequestBody Person person){
        if(persons.contains(person)){
            return person;
        }
        return null;
    }

    @GetMapping("/showall")
    public List<Person> showAllPersons(){
        return persons;
    }

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person){
        persons.add(person);
        return person;
    }

    @PutMapping("/update/{id}")
    public Person updatePerson(@PathVariable Integer id,
                               @RequestBody Person person){
        persons.get(id).setName(person.getName());
        persons.get(id).setAge(person.getAge());
        return persons.get(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable Integer id){
        persons.remove(id);
        return "Person с  id " + id + " успешно удалён";
    }
}
