package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.adapter.out.persistence.TaskPersistenceAdapter;
import com.example.tasktrackerspring.application.domain.model.Status;
import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.port.in.SearchStatusUseCase;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import com.example.tasktrackerspring.helper.JsonExtension;
import com.example.tasktrackerspring.helper.TestRepositoryHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(JsonExtension.class)
public class SearchStatusServiceTest {
    @Test
    public void canSearchByStatus() {
        TestRepositoryHelper.CreateTask(1, "description", Status.TODO);
        TestRepositoryHelper.CreateTask(2, "description", Status.IN_PROGRESS);
        TestRepositoryHelper.CreateTask(3, "description", Status.DONE);
        TestRepositoryHelper.CreateTask(4, "description", Status.TODO);

        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestRepository.json");

        SearchStatusUseCase sut = new SearchStatusService(loadTaskPort);
        List<Task> tasks = sut.search(Status.TODO);

        assertEquals(2, tasks.size());
    }
}
