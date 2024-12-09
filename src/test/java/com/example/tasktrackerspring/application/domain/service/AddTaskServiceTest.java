package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.adapter.out.persistence.TaskPersistenceAdapter;
import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.port.in.AddTaskUseCase;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTaskServiceTest {
    @Test
    public void addTaskWithStateTodo() {
        AddTaskUseCase sut = new AddTaskService();
        TaskID taskID = new TaskID(UUID.randomUUID());
        Description description = new Description("description");
        AddTaskCommand addTaskCommand = new AddTaskCommand(taskID, description, Status.TODO);

        sut.add(addTaskCommand);

        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("");
        Task loadedTask = loadTaskPort.find(taskID);
        assertEquals(description, loadedTask.description());
    }

    @Test
    public void addTaskWithStateTodo_other() {
        AddTaskUseCase sut = new AddTaskService();
        TaskID taskID = new TaskID(UUID.randomUUID());
        Description description = new Description("description2");
        AddTaskCommand addTaskCommand = new AddTaskCommand(taskID, description, Status.TODO);

        sut.add(addTaskCommand);

        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("");
        Task loadedTask = loadTaskPort.find(taskID);
        assertEquals(description, loadedTask.description());
    }
}