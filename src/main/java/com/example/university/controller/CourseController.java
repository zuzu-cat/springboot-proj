package com.example.university.controller;

import java.util.List;
import java.util.UUID;

import com.example.university.api.CourseApi;
import com.example.university.dto.CourseDto;
import com.example.university.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController implements CourseApi {

    @Autowired
    private CourseService courseService;

    public CourseDto getCourseById(UUID courseId) {
        return CourseDto.fromCourse(courseService.getCourseById(courseId));
    }

    public List<CourseDto> getCoursesBySubjectId(UUID subjectId) {
        return CourseDto.fromCourses(courseService.getCoursesBySubjectId(subjectId));
    }
}
