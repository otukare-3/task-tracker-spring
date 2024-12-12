package com.example.tasktrackerspring.application.port.in;

import com.example.tasktrackerspring.application.domain.model.Status;
import com.example.tasktrackerspring.application.domain.model.Task;

import java.util.List;

public interface SearchStatusUseCase {
    List<Task> search(Status status);
}
