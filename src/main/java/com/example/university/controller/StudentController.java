package com.example.university.controller;

import java.util.UUID;

import com.example.university.api.StudentApi;
import com.example.university.dto.StudentDto;
import com.example.university.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController implements StudentApi {

    @Autowired
    private StudentService studentService;

    @Override
    public StudentDto getStudentById(UUID studentId) {
        return StudentDto.fromStudent(studentService.getStudentById(studentId));
    }
}
