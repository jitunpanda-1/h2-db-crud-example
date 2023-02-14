package com.example.h2dbcrudexample.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "person")
public class PersonDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
}
