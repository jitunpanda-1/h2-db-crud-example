package com.example.h2dbcrudexample.service;

import com.example.h2dbcrudexample.dto.PersonRequest;
import com.example.h2dbcrudexample.entity.PersonDAO;
import com.example.h2dbcrudexample.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonDAO savePerson(PersonRequest personRequest) {
        PersonDAO personDAO = prepareDAOData(personRequest);
        return personRepository.save(personDAO);
    }

    private PersonDAO prepareDAOData(PersonRequest personRequest) {
        PersonDAO personDAO = new PersonDAO();
        personDAO.setFirstName(personRequest.getFirstName());
        personDAO.setLastName(personRequest.getLastName());
        personDAO.setEmail(personRequest.getEmail());
        personDAO.setMobileNumber(personRequest.getMobileNumber());
        return personDAO;
    }
}
