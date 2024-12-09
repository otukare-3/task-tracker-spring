package com.example.tasktrackerspring.application.domain.service;

public record AddTaskCommand(TaskID taskID, Description description, Status todo) {
    public AddTaskCommand(TaskID taskID, Description description, Status todo) {
        if(taskID == null) {
            throw new IllegalArgumentException("taskID cannot be null");
        }
        this.taskID = taskID;
        this.description = description;
        this.todo = todo;
    }
}
