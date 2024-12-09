package com.example.tasktrackerspring.adapter.out.persistence;

import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.service.TaskID;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class TaskPersistenceAdapter implements LoadTaskPort {
    private final String destination;

    public TaskPersistenceAdapter(String destination) {
        if (destination == null || destination.isEmpty()) throw new IllegalArgumentException("destination is null");
        this.destination = destination;
    }

    @Override
    public Optional<Task> find(TaskID taskID) {
        List<Task> tasks = findAll();
        return tasks.stream().filter(task -> task.id().equals(taskID)).findFirst();
    }

    @Override
    public List<Task> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<TaskJsonEntity> taskJsonEntities;

        try {
            taskJsonEntities = mapper.readValue(new File(destination), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        TaskMapper taskMapper = new TaskMapper();
        return taskJsonEntities.stream().map(taskMapper::mapToDomainEntity).toList();
    }
}
