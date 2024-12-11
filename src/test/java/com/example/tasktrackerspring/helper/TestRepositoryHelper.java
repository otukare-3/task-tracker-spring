package com.example.tasktrackerspring.helper;

import com.example.tasktrackerspring.adapter.out.persistence.TaskPersistenceAdapter;
import com.example.tasktrackerspring.application.domain.model.Description;
import com.example.tasktrackerspring.application.domain.model.Status;
import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.model.TaskID;
import com.example.tasktrackerspring.application.port.out.InsertTaskPort;

import java.time.LocalDateTime;

public class TestRepositoryHelper {
    public static void CreateTask(int id, String description, Status status) {
        TaskPersistenceAdapter taskPersistenceAdapter = new TaskPersistenceAdapter("TestRepository.json");
        ((InsertTaskPort) taskPersistenceAdapter).insert(new Task(
                new TaskID(id),
                new Description(description),
                status,
                LocalDateTime.now(),
                LocalDateTime.now()
        ));
    }
}
