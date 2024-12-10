package com.example.tasktrackerspring.application.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskIDTest {
    @Test
    public void sameUuidIsEquivalent() {
        Integer id = 1;
        TaskID taskId1 = new TaskID(id);
        TaskID taskId2 = new TaskID(id);
        assertEquals(taskId1, taskId2);
    }

    @Test
    public void valueIsRequired() {
        assertThrows(IllegalArgumentException.class, () -> new TaskID(null));
    }

    @Test
    public void canSaveValue() {
        Integer id = 1;
        TaskID taskId1 = new TaskID(id);
        assertEquals(id, taskId1.value());
    }
}