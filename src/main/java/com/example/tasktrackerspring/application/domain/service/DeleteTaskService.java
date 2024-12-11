package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.application.domain.model.TaskID;
import com.example.tasktrackerspring.application.port.in.DeleteTaskUseCase;
import com.example.tasktrackerspring.application.port.out.DeleteTaskPort;

public class DeleteTaskService implements DeleteTaskUseCase {
    private final DeleteTaskPort deleteTaskPort;

    public DeleteTaskService(DeleteTaskPort deleteTaskPort) {
        this.deleteTaskPort = deleteTaskPort;
    }

    @Override
    public void delete(TaskID taskID) {
        deleteTaskPort.delete(taskID);
    }
}
