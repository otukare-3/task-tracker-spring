package com.example.tasktrackerspring.application.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TaskTest {

    @Test
    public void canCreate() {
        assertDoesNotThrow(() -> {
                    Task task = new Task(
                            new TaskID(1),
                            new Description("description"),
                            Status.TODO,
                            LocalDateTime.now(),
                            LocalDateTime.now()
                    );
                }
        );
    }
}