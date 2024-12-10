package com.example.tasktrackerspring.adapter.out.persistence;

import com.example.tasktrackerspring.application.domain.model.Description;
import com.example.tasktrackerspring.application.domain.model.Status;
import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.model.TaskID;
import com.example.tasktrackerspring.application.port.out.InsertTaskPort;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TaskPersistenceAdapterTest {

    @Test
    public void destinationIsRequired() {
        assertThrows(IllegalArgumentException.class, () -> new TaskPersistenceAdapter(null));
        assertThrows(IllegalArgumentException.class, () -> new TaskPersistenceAdapter(""));
    }

    @Test
    public void findable() {
        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestData/Test1.json");
        TaskID target = new TaskID(1);
        Optional<Task> task = loadTaskPort.find(target);
        assertEquals("Test1 Description", task.orElseThrow().description().getValue());
    }

    @Test
    public void canFindMultipleData() {
        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestData/Test4.json");
        TaskID target = new TaskID(1);
        Optional<Task> task = loadTaskPort.find(target);
        assertEquals("Test4-1 Description", task.orElseThrow().description().getValue());
    }

    @Test
    public void canFindAll() {
        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestData/Test4.json");
        List<Task> tasks = loadTaskPort.findAll();
        assertEquals(2, tasks.size());
    }

    @Test
    public void canInsert() {
        InsertTaskPort sut = new TaskPersistenceAdapter("TestData/Test5.json");
        Task task = new Task(
                new TaskID(1),
                new Description("description"),
                Status.DONE,
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        sut.insert(task);

        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestData/Test5.json");
        assertNotNull(loadTaskPort.find(new TaskID(1)));
    }

    @Test
    public void emptyFileReturnsEmptyList() {
        LoadTaskPort loadTaskPort = new TaskPersistenceAdapter("TestData/Test6.json");
        List<Task> tasks = loadTaskPort.findAll();
        assertEquals(0, tasks.size());
    }
}