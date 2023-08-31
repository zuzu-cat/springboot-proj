package com.example.university.service;

import java.util.UUID;

import com.example.university.model.Student;
import com.example.university.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentById(UUID studentId) {
        return studentRepository.findByIdOrThrow(studentId);
    }
}
