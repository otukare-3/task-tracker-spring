package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.adapter.out.persistence.TaskPersistenceAdapter;
import com.example.tasktrackerspring.application.domain.model.Status;
import com.example.tasktrackerspring.application.domain.model.TaskID;
import com.example.tasktrackerspring.application.port.in.MarkDoneUseCase;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import com.example.tasktrackerspring.application.port.out.UpdateTaskPort;
import com.example.tasktrackerspring.helper.JsonExtension;
import com.example.tasktrackerspring.helper.TestRepositoryHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(JsonExtension.class)
public class MarkDoneServiceTest {
    @Test
    public void canMarkDone() {
        TestRepositoryHelper.CreateTask(1, "description", Status.TODO);
        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestRepository.json");
        UpdateTaskPort updateTaskPort = new TaskPersistenceAdapter("TestRepository.json");
        MarkDoneUseCase sut = new MarkDoneService(loadTaskPort, updateTaskPort);
        TaskID taskID = new TaskID(1);

        sut.done(taskID);

        assertEquals(Status.DONE, loadTaskPort.find(taskID).orElseThrow().status());
    }
}
