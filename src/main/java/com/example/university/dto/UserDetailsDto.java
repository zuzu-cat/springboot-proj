package com.example.university.dto;

import java.time.LocalDate;

import com.example.university.model.UserDetails;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetailsDto {

    private String firstname;

    private String lastname;

    private String email;

    private LocalDate birthdate;

    public static UserDetailsDto fromUserDetails(UserDetails userDetails) {
        return UserDetailsDto.builder()
                             .firstname(userDetails.getFirstname())
                             .lastname(userDetails.getLastname())
                             .email(userDetails.getEmail())
                             .birthdate(userDetails.getBirthdate())
                             .build();
    }
}
