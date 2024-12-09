package com.example.tasktrackerspring.application.domain.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescriptionTest {
    @Test
    public void canSaveValue() {
        String descriptionStr = "description";
        Description description = new Description(descriptionStr);
        assertEquals(descriptionStr, description.getValue());
    }

    @Test
    public void canSaveValue_other() {
        String descriptionStr = "description2";
        Description description = new Description(descriptionStr);
        assertEquals(descriptionStr, description.getValue());
    }
}