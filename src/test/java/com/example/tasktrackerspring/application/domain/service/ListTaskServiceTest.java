package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.adapter.out.persistence.TaskPersistenceAdapter;
import com.example.tasktrackerspring.application.domain.model.Status;
import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.port.in.ListTaskUseCase;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import com.example.tasktrackerspring.helper.JsonExtension;
import com.example.tasktrackerspring.helper.TestRepositoryHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(JsonExtension.class)
public class ListTaskServiceTest {
    @Test
    public void canList() {
        TestRepositoryHelper.CreateTask(1, "description", Status.DONE);
        TestRepositoryHelper.CreateTask(2, "description2", Status.IN_PROGRESS);
        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestRepository.json");

        ListTaskUseCase sut = new ListTaskService(loadTaskPort);
        List<Task> tasks = sut.list();

        assertEquals(2, tasks.size());
    }
}
