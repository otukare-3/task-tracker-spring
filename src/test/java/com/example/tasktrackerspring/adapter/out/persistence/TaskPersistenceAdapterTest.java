package com.example.tasktrackerspring.adapter.out.persistence;

import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.service.TaskID;
import com.example.tasktrackerspring.application.port.out.LoadTaskPort;
import org.junit.jupiter.api.Test;

import java.util.UUID;

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
        TaskID target = new TaskID(UUID.fromString("9eb2f0ad-4076-46b2-a14b-2c08ee63f85a"));
        Task task = loadTaskPort.find(target);
        assertEquals("Test1 Description", task.description().getValue());
    }
}