package com.example.tasktrackerspring.application.domain.service;

public record AddTaskCommand(TaskID taskID, Description description, Status status) {
    public AddTaskCommand {
        if (taskID == null) {
            throw new IllegalArgumentException("taskID cannot be null");
        }
        if (status == null) {
            throw new IllegalArgumentException("status cannot be null");
        }
        if (description == null) {
            throw new IllegalArgumentException("description cannot be null");
        }
    }
}
