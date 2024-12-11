package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.port.in.UpdateTaskUseCase;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import com.example.tasktrackerspring.application.port.out.UpdateTaskPort;

import java.time.LocalDateTime;
import java.util.Optional;

public class UpdateTaskService implements UpdateTaskUseCase {
    private final UpdateTaskPort updateTaskPort;
    private final LoadTaskPort loadTaskPort;

    public UpdateTaskService(LoadTaskPort loadTaskPort, UpdateTaskPort updateTaskPort) {
        this.loadTaskPort = loadTaskPort;
        this.updateTaskPort = updateTaskPort;
    }

    @Override
    public void update(UpdateTaskCommand updateTaskCommand) {
        Optional<Task> optionalUpdateTargetTask = loadTaskPort.find(updateTaskCommand.taskID());
        Task updateTargetTask = optionalUpdateTargetTask.orElseThrow();

        updateTaskPort.update(
                new Task(
                        updateTaskCommand.taskID(),
                        updateTaskCommand.description(),
                        updateTargetTask.status(),
                        updateTargetTask.createdAt(),
                        LocalDateTime.now()
                )
        );
    }
}
