package com.example.university.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Data
public class Teacher {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    @Embedded
    private UserDetails userDetails;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
    private List<Course> courses;
}
