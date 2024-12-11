package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.adapter.out.persistence.TaskPersistenceAdapter;
import com.example.tasktrackerspring.application.domain.model.Status;
import com.example.tasktrackerspring.application.domain.model.TaskID;
import com.example.tasktrackerspring.application.port.in.MarkInProgressUseCase;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import com.example.tasktrackerspring.helper.JsonExtension;
import com.example.tasktrackerspring.helper.TestRepositoryHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(JsonExtension.class)
public class MarkInProgressServiceTest {
    @Test
    public void canMarkInProgress() {
        TestRepositoryHelper.CreateTask(1, "description", Status.TODO);
        TaskPersistenceAdapter taskPersistenceAdapter = new TaskPersistenceAdapter("TestRepository.json");

        MarkInProgressUseCase sut = new MarkInProgressService(taskPersistenceAdapter, taskPersistenceAdapter);

        TaskID taskID = new TaskID(1);
        sut.markInProgress(taskID);

        assertEquals(Status.IN_PROGRESS, ((LoadTaskPort) taskPersistenceAdapter).find(taskID).orElseThrow().status());
    }
}
