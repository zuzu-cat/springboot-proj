package com.example.university.controller;

import java.util.UUID;

import com.example.university.api.TeacherApi;
import com.example.university.dto.TeacherDto;
import com.example.university.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController implements TeacherApi {

    @Autowired
    private TeacherService teacherService;

    @Override
    public TeacherDto getTeacherById(UUID teacherId) {
        return TeacherDto.fromTeacher(teacherService.getTeacherById(teacherId));
    }
}
