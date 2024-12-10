package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.application.domain.model.Description;
import com.example.tasktrackerspring.application.domain.model.Status;
import com.example.tasktrackerspring.application.domain.model.TaskID;

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
