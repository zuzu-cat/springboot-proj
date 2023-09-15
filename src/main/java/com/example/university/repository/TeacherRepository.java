package com.example.university.repository;

import java.util.Optional;
import java.util.UUID;

import com.example.university.model.Teacher;

import org.springframework.data.jpa.repository.EntityGraph;

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.LOAD;

public interface TeacherRepository extends GenericRepository<Teacher> {
    //this means that when we retrieve corosponding courses for teachers that they'll be eagerly fetched
    @EntityGraph(type = LOAD, attributePaths = {"courses"})
    Optional<Teacher> findById(UUID teacherId);
}
