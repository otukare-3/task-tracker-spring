package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.application.domain.model.Description;
import com.example.tasktrackerspring.application.domain.model.TaskID;

public record UpdateTaskCommand(
        TaskID taskID,
        Description description
) {
    public UpdateTaskCommand {
        if (taskID == null) {
            throw new IllegalArgumentException("Task ID must not be null or empty");
        }

        if (description == null) {
            throw new IllegalArgumentException("Description must not be null or empty");
        }
    }
}
