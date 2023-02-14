package com.example.h2dbcrudexample.controller;

import com.example.h2dbcrudexample.dto.PersonRequest;
import com.example.h2dbcrudexample.entity.PersonDAO;
import com.example.h2dbcrudexample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/personDetails")
    public PersonDAO getPersonDetails(){
        return new PersonDAO();
    }

    @PostMapping("/savePersonDetails")
    public PersonDAO savePersonDetails(@RequestBody PersonRequest personRequest){
        return personService.savePerson(personRequest);
    }
}
