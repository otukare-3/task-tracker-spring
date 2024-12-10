package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.application.port.in.AddTaskUseCase;
import com.example.tasktrackerspring.application.port.out.InsertTaskPort;

public class AddTaskService implements AddTaskUseCase {
    private InsertTaskPort insertTaskPort;

    public AddTaskService(InsertTaskPort insertTaskPort) {
        this.insertTaskPort = insertTaskPort;
    }

    @Override
    public void add(AddTaskCommand addTaskCommand) {
    }
}
