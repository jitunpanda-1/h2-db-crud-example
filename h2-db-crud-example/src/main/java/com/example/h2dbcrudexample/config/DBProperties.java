package com.example.h2dbcrudexample.config;

import lombok.Data;

@Data
public class DBProperties {
    private String url;
    private String userName;
    private String password;
    private String driverClassName;
}
