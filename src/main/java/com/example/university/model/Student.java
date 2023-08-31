package com.example.university.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    @Embedded
    private UserDetails userDetails;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;
}
