package com.example.university.util;

import java.io.IOException;
import java.nio.file.Files;

import org.springframework.util.ResourceUtils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class FileUtils {

    public static String loadTextFileFromResources(String fileName) throws IOException {
        return new String(Files.readAllBytes(ResourceUtils.getFile("classpath:" + fileName)
                                                          .toPath()));
    }
}
