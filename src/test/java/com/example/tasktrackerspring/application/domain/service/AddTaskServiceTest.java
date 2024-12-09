package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.adapter.out.persistence.TaskPersistenceAdapter;
import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.port.in.AddTaskUseCase;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTaskServiceTest {
    @Test
    public void addTaskWithStateTodo() {
        AddTaskUseCase sut = new AddTaskService();
        TaskID taskID = new TaskID(UUID.fromString("34361936-1cb7-46ef-736d-d175d7218ef7"));
        Description description = new Description("Test2 Description");
        AddTaskCommand addTaskCommand = new AddTaskCommand(taskID, description, Status.TODO);

        sut.add(addTaskCommand);

        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestData/Test2.json");
        Optional<Task> loadedTask = loadTaskPort.find(taskID);
        assertEquals(description, loadedTask.orElseThrow().description());
        //TODO: 未完成
    }

    @Test
    public void addTaskWithStateTodo_other() {
        AddTaskUseCase sut = new AddTaskService();
        TaskID taskID = new TaskID(UUID.fromString("5b935b5e-e7b7-e2cb-30f3-cc9694b64dfa"));
        Description description = new Description("Test3 Description");
        AddTaskCommand addTaskCommand = new AddTaskCommand(taskID, description, Status.TODO);

        sut.add(addTaskCommand);

        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestData/Test3.json");
        Optional<Task> loadedTask = loadTaskPort.find(taskID);
        assertEquals(description, loadedTask.orElseThrow().description());
        //TODO: 未完成
    }
}