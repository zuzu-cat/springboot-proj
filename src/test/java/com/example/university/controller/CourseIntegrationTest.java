package com.example.university.controller;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class CourseIntegrationTest extends BaseIntegrationTest {

    private static final String HUXLEY_MATH_COURSE_ID = "f8ce32ec-3374-46d9-b32c-59c26032aaea";

    private static final String HUXLEY_MATH_COURSE_RESPONSE_PATH = "math-by-huxley-course-response.json";

    private static final String MATH_COURSES_RESPONSE_PATH = "math-courses-response.json";

    @Test
    public void getCourseById_courseDoesNotExist_throwsNotFoundError() throws Exception {
        assertNotFoundErrorWhenGettingByNonExistentId();
    }

    @Test
    public void getCourseById_courseExists_returnsCourse() throws Exception {
        getById(HUXLEY_MATH_COURSE_ID, HUXLEY_MATH_COURSE_RESPONSE_PATH);
    }

    @Test
    public void getCoursesBySubjectId_subjectDoesNotExist_throwsNotFoundError() throws Exception {
        assertNotFoundErrorWhenGettingByNonExistentId("?subjectId=%s");
    }

    @Test
    public void getCoursesBySubjectId_courseExists_returnsCourses() throws Exception {
        var path = buildURI(getBasePath(), "?subjectId=%s", MATH_SUBJECT_ID);
        //this will fail when you run in asia since the localdate will be off by 1 day
        getByIdWithPath(path, MATH_COURSES_RESPONSE_PATH);
    }

    @Override
    String getBasePath() {
        return "/api/courses";
    }
}
