package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.adapter.out.persistence.TaskPersistenceAdapter;
import com.example.tasktrackerspring.application.domain.model.Status;
import com.example.tasktrackerspring.application.domain.model.TaskID;
import com.example.tasktrackerspring.application.port.in.DeleteTaskUseCase;
import com.example.tasktrackerspring.application.port.out.DeleteTaskPort;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import com.example.tasktrackerspring.helper.JsonExtension;
import com.example.tasktrackerspring.helper.TestRepositoryHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(JsonExtension.class)
public class DeleteTaskServiceTest {
    @Test
    public void canDeleteTask() {
        TestRepositoryHelper.CreateTask(1, "description", Status.TODO);
        DeleteTaskPort deleteTaskPort = new TaskPersistenceAdapter("TestRepository.json");
        DeleteTaskUseCase sut = new DeleteTaskService(deleteTaskPort);

        sut.delete(new TaskID(1));

        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestRepository.json");
        assertEquals(0, loadTaskPort.findAll().size());
    }

    @Test
    public void canDeleteTask_multipleTasks() {
        TestRepositoryHelper.CreateTask(1, "description", Status.TODO);
        TestRepositoryHelper.CreateTask(2, "description", Status.TODO);
        DeleteTaskPort deleteTaskPort = new TaskPersistenceAdapter("TestRepository.json");
        DeleteTaskUseCase sut = new DeleteTaskService(deleteTaskPort);

        sut.delete(new TaskID(1));

        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestRepository.json");
        assertEquals(1, loadTaskPort.findAll().size());
    }
}
