package com.example.tasktrackerspring.application.port.in;

import com.example.tasktrackerspring.application.domain.service.UpdateTaskCommand;

public interface UpdateTaskUseCase {
    void update(UpdateTaskCommand updateTaskCommand);
}
