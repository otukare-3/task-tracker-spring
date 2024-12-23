package com.example.tasktrackerspring.application.port.out;

import com.example.tasktrackerspring.application.domain.model.Status;
import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.model.TaskID;

import java.util.List;
import java.util.Optional;

public interface LoadTaskPort {
    Optional<Task> find(TaskID taskID);

    List<Task> findAll();

    List<Task> searchByStatus(Status status);
}
