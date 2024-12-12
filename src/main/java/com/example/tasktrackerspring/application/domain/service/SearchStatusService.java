package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.application.domain.model.Status;
import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.port.in.SearchStatusUseCase;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;

import java.util.List;

public class SearchStatusService implements SearchStatusUseCase {
    private final LoadTaskPort loadTaskPort;

    public SearchStatusService(LoadTaskPort loadTaskPort) {
        this.loadTaskPort = loadTaskPort;
    }

    @Override
    public List<Task> search(Status status) {
        return loadTaskPort.searchByStatus(status);
    }
}
