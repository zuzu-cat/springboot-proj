package com.example.university.error.handler;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApplicationError {

    private String[] messages;

    private String url;
}
