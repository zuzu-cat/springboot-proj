package com.example.university.dto;

import java.util.List;
import java.util.UUID;

import com.example.university.model.Student;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;
import lombok.extern.java.Log;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Log
public class StudentDto {

    private UUID id;

    @JsonUnwrapped
    private UserDetailsDto userDetails;

    private List<CourseDto> courses;

    public static StudentDto fromStudent(Student student) {
        log.info("hey we're right before getting student details");
        log.info(student.getUserDetails().toString());
        return StudentDto.builder()
                         .id(student.getId())
                         .userDetails(UserDetailsDto.fromUserDetails(student.getUserDetails()))
                         .courses(CourseDto.fromCourses(student.getCourses()))
                         .build();
    }
}
