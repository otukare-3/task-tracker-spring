package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.adapter.out.persistence.TaskPersistenceAdapter;
import com.example.tasktrackerspring.application.domain.model.Description;
import com.example.tasktrackerspring.application.domain.model.Status;
import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.model.TaskID;
import com.example.tasktrackerspring.application.port.in.UpdateTaskUseCase;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import com.example.tasktrackerspring.application.port.out.UpdateTaskPort;
import com.example.tasktrackerspring.helper.JsonExtension;
import com.example.tasktrackerspring.helper.TestRepositoryHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(JsonExtension.class)
public class UpdateTaskServiceTest {
    @Test
    public void canUpdate() {
        TestRepositoryHelper.CreateTask(1, "Test7 Description", Status.TODO);
        UpdateTaskPort updateTaskPort = new TaskPersistenceAdapter("TestRepository.json");
        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestRepository.json");
        UpdateTaskUseCase sut = new UpdateTaskService(loadTaskPort, updateTaskPort);

        TaskID taskID = new TaskID(1);

        sut.update(
                new UpdateTaskCommand(
                        taskID,
                        new Description("Test7 Description Changed")
                )
        );

        Optional<Task> task = loadTaskPort.find(taskID);
        assertEquals("Test7 Description Changed", task.orElseThrow().description().getValue());
    }
}
