package com.example.university.api;

import java.util.UUID;

import com.example.university.dto.TeacherDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/teachers")
public interface TeacherApi {

    @GetMapping("{teacherId}")
    TeacherDto getTeacherById(@PathVariable UUID teacherId);
}
