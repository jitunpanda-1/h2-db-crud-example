package com.example.h2dbcrudexample.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class PersonRequest {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
}
