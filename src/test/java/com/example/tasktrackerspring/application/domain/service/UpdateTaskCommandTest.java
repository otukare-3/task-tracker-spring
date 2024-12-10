package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.application.domain.model.Description;
import com.example.tasktrackerspring.application.domain.model.TaskID;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UpdateTaskCommandTest {
    @Test
    public void canCreate() {
        assertDoesNotThrow(() -> {
            new UpdateTaskCommand(
                    new TaskID(1),
                    new Description("description")
            );
        });
    }

    @Test
    public void isRequiredTaskID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UpdateTaskCommand(
                    null,
                    new Description("description")
            );
        });
    }

    @Test
    public void isRequiredDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UpdateTaskCommand(
                    new TaskID(1),
                    null
            );
        });
    }
}