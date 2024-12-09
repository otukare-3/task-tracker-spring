package com.example.tasktrackerspring.application.port.in;

import com.example.tasktrackerspring.application.domain.service.AddTaskCommand;

public interface AddTaskUseCase {
    void add(AddTaskCommand addTaskCommand);
}
