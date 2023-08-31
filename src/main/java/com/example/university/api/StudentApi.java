package com.example.university.api;

import java.util.UUID;

import com.example.university.dto.StudentDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/students")
public interface StudentApi {

    @GetMapping("{studentId}")
    StudentDto getStudentById(@PathVariable UUID studentId);
}
