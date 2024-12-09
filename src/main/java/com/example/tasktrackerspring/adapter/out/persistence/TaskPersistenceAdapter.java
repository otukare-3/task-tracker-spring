package com.example.tasktrackerspring.adapter.out.persistence;

import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.service.TaskID;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TaskPersistenceAdapter implements LoadTaskPort {
    private final String destination;

    public TaskPersistenceAdapter(String destination) {
        if (destination == null || destination.isEmpty()) throw new IllegalArgumentException("destination is null");
        this.destination = destination;
    }

    @Override
    public Task find(TaskID taskID) {
        ObjectMapper mapper = new ObjectMapper();
        List<TaskJsonEntity> taskJsonEntities;

        try {
            //TODO: もっとパス簡単に
            taskJsonEntities = mapper.readValue(new File(Paths.get(destination).toAbsolutePath().toString()), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        TaskMapper taskMapper = new TaskMapper();

        Optional<TaskJsonEntity> optionalTask = taskJsonEntities.stream().filter((taskJsonEntity) -> UUID.fromString(taskJsonEntity.getTaskId()).equals(taskID.value())).findFirst();

        return taskMapper.mapToDomainEntity(optionalTask.orElseThrow());
    }
}
