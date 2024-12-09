package com.example.tasktrackerspring.application.domain.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AddTaskCommandTest {

    @Test
    public void idIsRequired() {
        TaskID taskId = null;
        Description description = new Description("description");
        assertThrows(IllegalArgumentException.class, () -> new AddTaskCommand(taskId, description, Status.DONE));
    }

    @Test
    public void statusIsRequired() {
        TaskID taskId = new TaskID(1);
        Description description = new Description("description");
        assertThrows(IllegalArgumentException.class, () -> new AddTaskCommand(taskId, description, null));
    }

    //TODO: descriptionは必須
}