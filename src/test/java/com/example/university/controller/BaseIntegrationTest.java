package com.example.university.controller;

import java.util.UUID;

import javax.transaction.Transactional;

import com.example.university.UniversityApplication;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.example.university.util.FileUtils.loadTextFileFromResources;
import static java.lang.String.format;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.testcontainers.shaded.org.apache.commons.lang.ArrayUtils.isNotEmpty;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = UniversityApplication.class)
@Transactional
public abstract class BaseIntegrationTest {

    protected static final String MATH_SUBJECT_ID = "7e569bab-dd07-459b-af54-69e5ea6cbfa3";

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    protected ResultActions getById(Object id, String expectedJsonPath) throws Exception {
        var path = buildURI(getBasePath(), "/%s", id);

        return getByIdWithPath(path, expectedJsonPath);
    }

    protected ResultActions getByIdWithPath(String path, String expectedJsonPath) throws Exception {
        var expectedJson = loadTextFileFromResources(expectedJsonPath);
        //make sure localdate conversion to 
        return mvc.perform(get(path)
                               .contentType(MediaType.APPLICATION_JSON))
                  .andExpect(status().isOk())
                  .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                  .andExpect(content().json(expectedJson));
    }

    protected void assertNotFoundErrorWhenGettingByNonExistentId() throws Exception {
        this.assertNotFoundErrorWhenGettingByNonExistentId("/%s");
    }

    protected void assertNotFoundErrorWhenGettingByNonExistentId(String endpoint) throws Exception {
        var path = buildURI(getBasePath(), endpoint, UUID.randomUUID());

        mvc.perform(get(path)
                        .contentType(MediaType.APPLICATION_JSON))
           .andExpect(status().isNotFound());
    }

    protected String buildURI(String basePath, String endpoint, Object... replacements) {
        String uri = basePath + endpoint;

        if (isNotEmpty(replacements)) {
            uri = format(uri, replacements);
        }
        return uri;
    }

    abstract String getBasePath();
}
