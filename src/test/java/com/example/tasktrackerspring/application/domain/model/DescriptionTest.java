package com.example.tasktrackerspring.application.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void isRequired() {
        assertThrows(IllegalArgumentException.class, () -> new Description(""));
        assertThrows(IllegalArgumentException.class, () -> new Description(null));
    }
}