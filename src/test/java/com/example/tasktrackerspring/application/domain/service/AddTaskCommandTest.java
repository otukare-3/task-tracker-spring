package com.example.tasktrackerspring.application.domain.service;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AddTaskCommandTest {

    @Test
    public void idIsRequired() {
        TaskID taskId = null;
        Description description = new Description("description");
        assertThrows(IllegalArgumentException.class, () -> new AddTaskCommand(taskId, description, Status.DONE));
    }

    //TODO: ステータスは必須
}