package com.example.university.repository;

import java.util.List;

import com.example.university.model.Course;
import com.example.university.model.Subject;

public interface CourseRepository extends GenericRepository<Course> {

    List<Course> findBySubject(Subject subject);
}
