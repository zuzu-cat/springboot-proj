package com.example.university.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.example.university.model.Course;
import com.example.university.model.Student;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;

import static java.util.stream.Collectors.toList;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code")
@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class CourseDto {

    private UUID id;

    private String code;

    private TeacherDto teacher;

    private SubjectDto subject;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    public static List<CourseDto> fromCourses(List<Course> courses) {
        return Optional.ofNullable(courses)
                       .orElseGet(ArrayList::new)
                       .stream()
                       .map(CourseDto::fromCourse)
                       .collect(toList());
    }

    public static CourseDto fromCourse(Course course) {
        return CourseDto.builder()
                        .id(course.getId())
                        .code(course.getCode())
                        .teacher(TeacherDto.fromTeacher(course.getTeacher()))
                        .subject(SubjectDto.fromSubject(course.getSubject()))
                        .build();
    }
}
