package com.example.university.controller;

import org.junit.jupiter.api.Test;

public class StudentIntegrationTest extends BaseIntegrationTest {

    private static final String ZENON_STUDENT_ID = "79f70291-cc22-4980-aa8c-0a410b777f47";

    private static final String ZENON_STUDENT_RESPONSE_PATH = "zenon-student-response.json";

    @Test
    public void getStudentById_studentDoesNotExist_throwsNotFoundError() throws Exception {
        assertNotFoundErrorWhenGettingByNonExistentId();
    }

    @Test
    public void getStudentById_studentExists_returnsStudent() throws Exception {
        getById(ZENON_STUDENT_ID, ZENON_STUDENT_RESPONSE_PATH);
    }

    @Override
    String getBasePath() {
        return "/api/students";
    }
}
