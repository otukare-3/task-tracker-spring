package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.adapter.out.persistence.TaskPersistenceAdapter;
import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.port.in.AddTaskUseCase;
import com.example.tasktrackerspring.application.port.out.InsertTaskPort;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTaskServiceTest {
    @Test
    public void addTaskWithStateTodo() {
        InsertTaskPort insertTaskPort = new TaskPersistenceAdapter("TestData/Test2.json");
        AddTaskUseCase sut = new AddTaskService(insertTaskPort);
        TaskID taskID = new TaskID(1);
        Description description = new Description("Test2 Description");
        AddTaskCommand addTaskCommand = new AddTaskCommand(taskID, description, Status.TODO);
        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestData/Test2.json");
        List<Task> beforeTasks = loadTaskPort.findAll();

        sut.add(addTaskCommand);

        assertEquals(beforeTasks.size() + 1, loadTaskPort.findAll().size());
        //TODO: 未完成
    }

    @Test
    public void addTaskWithStateTodo_other() {
        InsertTaskPort insertTaskPort = new TaskPersistenceAdapter("TestData/Test2.json");
        AddTaskUseCase sut = new AddTaskService(insertTaskPort);
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