package com.example.tasktrackerspring.helper;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.File;

public class JsonExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        File jsonFile = new File("TestRepository.json");
        if (jsonFile.exists()) {
            //noinspection ResultOfMethodCallIgnored
            jsonFile.delete();
        }
        //noinspection ResultOfMethodCallIgnored
        jsonFile.createNewFile();
    }
}
