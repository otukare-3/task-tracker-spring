package com.example.tasktrackerspring.application.domain.service;

import com.example.tasktrackerspring.adapter.out.persistence.TaskPersistenceAdapter;
import com.example.tasktrackerspring.application.domain.model.Description;
import com.example.tasktrackerspring.application.domain.model.Status;
import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.model.TaskID;
import com.example.tasktrackerspring.application.port.in.AddTaskUseCase;
import com.example.tasktrackerspring.application.port.out.InsertTaskPort;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import com.example.tasktrackerspring.helper.JsonExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(JsonExtension.class)
class AddTaskServiceTest {
    @Test
    public void addTaskWithStateTodo() {
        //TODO: JUnit Extension Model を試してみる
        InsertTaskPort insertTaskPort = new TaskPersistenceAdapter("TestRepository.json");
        AddTaskUseCase sut = new AddTaskService(insertTaskPort);

        TaskID taskID = new TaskID(1);
        Description description = new Description("Test2 Description");
        AddTaskCommand addTaskCommand = new AddTaskCommand(taskID, description, Status.TODO);

        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestRepository.json");
        List<Task> beforeTasks = loadTaskPort.findAll();

        sut.add(addTaskCommand);

        assertEquals(beforeTasks.size() + 1, loadTaskPort.findAll().size());
    }

    @Test
    public void addTaskWithStateTodo_other() {
        InsertTaskPort insertTaskPort = new TaskPersistenceAdapter("TestRepository.json");
        AddTaskUseCase sut = new AddTaskService(insertTaskPort);
        TaskID taskID = new TaskID(1);
        Description description = new Description("Test3 Description");
        AddTaskCommand addTaskCommand = new AddTaskCommand(taskID, description, Status.TODO);

        sut.add(addTaskCommand);

        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestRepository.json");
        Optional<Task> loadedTask = loadTaskPort.find(taskID);
        assertEquals(description, loadedTask.orElseThrow().description());
    }
}