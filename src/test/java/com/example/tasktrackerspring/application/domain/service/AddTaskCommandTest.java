package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.application.domain.model.Description;
import com.example.tasktrackerspring.application.domain.model.Status;
import com.example.tasktrackerspring.application.domain.model.TaskID;
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

    @Test
    public void descriptionIsRequired() {
        TaskID taskId = new TaskID(1);
        assertThrows(IllegalArgumentException.class, () -> new AddTaskCommand(taskId, null, Status.TODO));
    }
}