package com.example.university.api;

import java.util.List;
import java.util.UUID;

import com.example.university.dto.CourseDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/courses")
public interface CourseApi {

    @GetMapping("{courseId}")
    CourseDto getCourseById(@PathVariable UUID courseId);

    @GetMapping
    List<CourseDto> getCoursesBySubjectId(@RequestParam(name = "subject_id") UUID subjectId);
}
