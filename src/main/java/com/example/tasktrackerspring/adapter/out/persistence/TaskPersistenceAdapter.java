package com.example.tasktrackerspring.adapter.out.persistence;

import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.service.TaskID;
import com.example.tasktrackerspring.application.port.out.InsertTaskPort;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskPersistenceAdapter implements LoadTaskPort, InsertTaskPort {
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
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<TaskJsonEntity> taskJsonEntities = mapper.readValue(new File(destination), new TypeReference<>() {
            });

            TaskMapper taskMapper = new TaskMapper();

            return taskJsonEntities.stream().map(taskMapper::mapToDomainEntity).toList();
        } catch (MismatchedInputException _) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    @Override
    public void insert(Task task) {
        List<Task> tasks = findAll();
        tasks.add(task);

        TaskMapper taskMapper = new TaskMapper();
        List<TaskJsonEntity> taskJsonEntities = taskMapper.mapToJsonEntityList(tasks);

        ObjectMapper mapper = new ObjectMapper();

        try (FileWriter fileWriter = new FileWriter(destination)) {
            fileWriter.write(mapper.writeValueAsString(taskJsonEntities));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
