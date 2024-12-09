package com.example.tasktrackerspring.adapter.out.persistence;

import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.service.TaskID;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}