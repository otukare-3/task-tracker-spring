package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.adapter.out.persistence.TaskPersistenceAdapter;
import com.example.tasktrackerspring.application.domain.model.Description;
import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.model.TaskID;
import com.example.tasktrackerspring.application.port.in.UpdateTaskUseCase;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateTaskServiceTest {
    @Test
    public void canCreate() {
        // TODO: 実装中
        TaskPersistenceAdapter taskPersistenceAdapter = new TaskPersistenceAdapter("TestData/Test7.json");
        UpdateTaskUseCase sut = new UpdateTaskService();

        TaskID taskID = new TaskID(1);

        sut.update(
                new UpdateTaskCommand(
                        taskID,
                        new Description("Test7 Description Changed")
                )
        );

        Optional<Task> task = ((LoadTaskPort) taskPersistenceAdapter).find(taskID);
        assertEquals("Test7 Description Changed", task.orElseThrow().description().getValue());
    }
}
