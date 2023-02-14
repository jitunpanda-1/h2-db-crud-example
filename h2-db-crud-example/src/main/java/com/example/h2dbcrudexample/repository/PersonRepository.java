package com.example.h2dbcrudexample.repository;

import com.example.h2dbcrudexample.entity.PersonDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonDAO, Long> {
}
