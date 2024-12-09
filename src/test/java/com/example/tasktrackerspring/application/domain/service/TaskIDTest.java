package com.example.tasktrackerspring.application.domain.service;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TaskIDTest {
    @Test
    public void sameUuidIsEquivalent() {
        UUID uuid = UUID.randomUUID();
        TaskID taskID1 = new TaskID(uuid);
        TaskID taskID2 = new TaskID(uuid);
        assertEquals(taskID1, taskID2);
    }

    @Test
    public void valueIsRequired() {
        assertThrows(IllegalArgumentException.class, () -> new TaskID(null));
    }

    @Test
    public void canSaveValue() {
        UUID uuid = UUID.randomUUID();
        TaskID taskID1 = new TaskID(uuid);
        assertEquals(uuid, taskID1.value());
    }
}