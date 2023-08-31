package com.example.university.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.university.model.Course;
import com.example.university.model.Teacher;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Builder;
import lombok.Data;

import static java.util.stream.Collectors.toList;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherDto {

    private UUID id;

    @JsonUnwrapped
    private UserDetailsDto userDetails;

    private List<String> courses;

    public static TeacherDto fromTeacher(Teacher teacher) {
        return TeacherDto.builder()
                         .id(teacher.getId())
                         .userDetails(UserDetailsDto.fromUserDetails(teacher.getUserDetails()))
                         .courses(Optional.ofNullable(teacher.getCourses()).orElseGet(ArrayList::new).stream().map(
                             Course::getCode).collect(toList()))
                         .build();
    }
}
