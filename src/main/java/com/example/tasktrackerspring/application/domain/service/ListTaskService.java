package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.port.in.ListTaskUseCase;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;

import java.util.List;

public class ListTaskService implements ListTaskUseCase {
    private final LoadTaskPort loadTaskPort;

    public ListTaskService(LoadTaskPort loadTaskPort) {
        this.loadTaskPort = loadTaskPort;
    }

    @Override
    public List<Task> list() {
        return loadTaskPort.findAll();
    }

}
