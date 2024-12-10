package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.adapter.out.persistence.TaskPersistenceAdapter;
import com.example.tasktrackerspring.application.domain.model.TaskID;
import com.example.tasktrackerspring.application.port.in.DeleteTaskUseCase;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import org.junit.jupiter.api.Test;

public class DeleteTaskServiceTest {
    @Test
    public void canCreate() {
        DeleteTaskUseCase sut = new DeleteTaskService();
        sut.delete(new TaskID(1));

        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("");
        //TODO: 実装中
    }
}
