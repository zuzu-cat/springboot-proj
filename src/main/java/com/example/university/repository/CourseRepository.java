package com.example.university.repository;

import java.util.List;

import com.example.university.model.Course;
import com.example.university.model.Subject;

public interface CourseRepository extends GenericRepository<Course> {
    // custom to find courses by subjects and not just ids 
    List<Course> findBySubject(Subject subject);

    //you can pass in a list of field names that you want to eagarly fetch, this is in the fields to initalize argument

}
