package com.example.university.service;

import java.util.UUID;

import com.example.university.error.exception.EntityNotFoundException;
import com.example.university.model.Teacher;
import com.example.university.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher getTeacherById(UUID teacherId) {
        return teacherRepository.findById(teacherId)
                                .orElseThrow(() -> new EntityNotFoundException(teacherId.toString()));
    }
}
