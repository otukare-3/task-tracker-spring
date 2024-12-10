package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.port.in.AddTaskUseCase;
import com.example.tasktrackerspring.application.port.out.InsertTaskPort;

import java.time.LocalDateTime;

public class AddTaskService implements AddTaskUseCase {
    private final InsertTaskPort insertTaskPort;

    public AddTaskService(InsertTaskPort insertTaskPort) {
        this.insertTaskPort = insertTaskPort;
    }

    @Override
    public void add(AddTaskCommand addTaskCommand) {

        Task task = new Task(
                addTaskCommand.taskID(),
                addTaskCommand.description(),
                addTaskCommand.status(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        insertTaskPort.insert(task);
    }
}
