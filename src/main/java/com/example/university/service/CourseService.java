package com.example.university.service;

import java.util.List;
import java.util.UUID;

import com.example.university.model.Course;
import com.example.university.repository.CourseRepository;
import com.example.university.repository.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Course getCourseById(UUID courseId) {
        return courseRepository.findByIdOrThrow(courseId);
    }

    public List<Course> getCoursesBySubjectId(UUID subjectId) {
        return courseRepository.findBySubject(subjectRepository.findByIdOrThrow(subjectId));
    }
}
