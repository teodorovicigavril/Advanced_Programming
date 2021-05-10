package com.example.demo.controllers;

import com.example.demo.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final List<Person> personList = new ArrayList<>();
    public PersonController() {
        personList.add(new Person(1, "Gabi"));
        personList.add(new Person(2, "Alin"));
        createPerson("test");
        updatePerson(3,"new name");
        deletePerson(3);
    }
    @GetMapping
    public List<Person> getPersonList() {
        return personList;
    }
    @GetMapping("/count")
    public int countPersonList() {
        return personList.size();
    }
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return personList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    //////////////////

    @PostMapping
    public int createPerson(@RequestParam String name) {
        int id = 1 + personList.size();
        personList.add(new Person(id, name));
        return id;
    }

    @PostMapping(value = "/obj", consumes="application/json")
    public ResponseEntity<String> createPerson(@RequestBody Person person) {
        personList.add(person);
        return new ResponseEntity<>("Person created successfully", HttpStatus.CREATED);
    }


    //////////////////

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable int id, @RequestParam String name) {
        Person person = findById(id);
        if (person == null) {
            return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND); //or GONE
        }
        person.setName(name);
        return new ResponseEntity<>("Person updated successsfully", HttpStatus.OK);
    }

    Person findById(int id){
        return personList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }


    //////////////////

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        Person person = findById(id);
        if (person == null) {
            return new ResponseEntity<>("Person not found", HttpStatus.GONE);
        }
        personList.remove(person);
        return new ResponseEntity<>("Person removed", HttpStatus.OK);
    }

}
