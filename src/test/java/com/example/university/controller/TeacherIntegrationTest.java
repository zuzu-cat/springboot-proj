package com.example.university.controller;

import org.junit.jupiter.api.Test;

public class TeacherIntegrationTest extends BaseIntegrationTest {

    private static final String HUXLEY_TEACHER_ID = "15e7e4ce-44ec-486a-bb1f-cdc6ce533e25";

    private static final String HUXLEY_TEACHER_RESPONSE_PATH = "huxley-teacher-response.json";

    @Test
    public void getTeacherById_teacherDoesNotExist_throwsNotFoundError() throws Exception {
        assertNotFoundErrorWhenGettingByNonExistentId();
    }

    @Test
    public void getTeacherById_teacherExists_returnsTeacher() throws Exception {
        getById(HUXLEY_TEACHER_ID, HUXLEY_TEACHER_RESPONSE_PATH);
    }

    @Override
    String getBasePath() {
        return "/api/teachers";
    }
}
