package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.application.domain.model.Status;
import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.model.TaskID;
import com.example.tasktrackerspring.application.port.in.MarkInProgressUseCase;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import com.example.tasktrackerspring.application.port.out.UpdateTaskPort;

import java.time.LocalDateTime;

public class MarkInProgressService implements MarkInProgressUseCase {
    private final UpdateTaskPort updateTaskPort;
    private final LoadTaskPort loadTaskPort;

    public MarkInProgressService(LoadTaskPort loadTaskPort, UpdateTaskPort updateTaskPort) {
        this.loadTaskPort = loadTaskPort;
        this.updateTaskPort = updateTaskPort;
    }

    @Override
    public void markInProgress(TaskID taskID) {
        Task targetTask = loadTaskPort.find(taskID).orElseThrow();

        updateTaskPort.update(
                new Task(
                        targetTask.id(),
                        targetTask.description(),
                        Status.IN_PROGRESS,
                        targetTask.createdAt(),
                        LocalDateTime.now()
                )
        );
    }
}
