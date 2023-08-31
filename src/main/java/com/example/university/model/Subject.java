package com.example.university.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Data
public class Subject {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subject")
    private List<Course> courses;
}
