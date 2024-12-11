package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.application.domain.model.Status;
import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.model.TaskID;
import com.example.tasktrackerspring.application.port.in.MarkDoneUseCase;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import com.example.tasktrackerspring.application.port.out.UpdateTaskPort;

import java.time.LocalDateTime;

public class MarkDoneService implements MarkDoneUseCase {
    private final LoadTaskPort loadTaskPort;
    private final UpdateTaskPort updateTaskPort;

    public MarkDoneService(LoadTaskPort loadTaskPort, UpdateTaskPort updateTaskPort) {
        this.loadTaskPort = loadTaskPort;
        this.updateTaskPort = updateTaskPort;
    }

    @Override
    public void done(TaskID taskID) {
        Task targetTask = loadTaskPort.find(taskID).orElseThrow();

        updateTaskPort.update(new Task(
                targetTask.id(),
                targetTask.description(),
                Status.DONE,
                targetTask.createdAt(),
                LocalDateTime.now()
        ));
    }
}
