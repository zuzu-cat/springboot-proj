package com.example.university.model;

import java.time.LocalDate;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class UserDetails {

    private String firstname;

    private String lastname;

    private String address;

    private String zipCode;

    private String state;

    private String email;

    private String password;

    private LocalDate birthdate;
}
