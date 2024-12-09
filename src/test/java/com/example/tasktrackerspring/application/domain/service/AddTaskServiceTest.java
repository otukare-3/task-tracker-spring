package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.adapter.out.persistence.TaskPersistenceAdapter;
import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.port.in.AddTaskUseCase;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTaskServiceTest {
    @Test
    public void addTaskWithStateTodo() {
        AddTaskUseCase sut = new AddTaskService();
        TaskID taskID = new TaskID(1);
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
        TaskID taskID = new TaskID(1);
        Description description = new Description("Test3 Description");
        AddTaskCommand addTaskCommand = new AddTaskCommand(taskID, description, Status.TODO);

        sut.add(addTaskCommand);

        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestData/Test3.json");
        Optional<Task> loadedTask = loadTaskPort.find(taskID);
        assertEquals(description, loadedTask.orElseThrow().description());
        //TODO: 未完成
    }
}