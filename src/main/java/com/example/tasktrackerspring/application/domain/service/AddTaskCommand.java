package com.example.tasktrackerspring.application.domain.service;

public record AddTaskCommand(TaskID taskID, Description description, Status todo) {
    public AddTaskCommand {
        if (taskID == null) {
            throw new IllegalArgumentException("taskID cannot be null");
        }
    }
}
