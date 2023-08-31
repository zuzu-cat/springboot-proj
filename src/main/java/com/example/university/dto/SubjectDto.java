package com.example.university.dto;

import java.util.UUID;

import com.example.university.model.Subject;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubjectDto {

    private UUID id;

    private String name;

    public static SubjectDto fromSubject(Subject subject) {
        return SubjectDto.builder()
                         .id(subject.getId())
                         .name(subject.getName())
                         .build();
    }
}
