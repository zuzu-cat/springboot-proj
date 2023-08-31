package com.example.university.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class EntityNotFoundException extends RuntimeException {

    @Getter
    private String lookupValue;
}
