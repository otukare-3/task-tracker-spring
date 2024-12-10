package com.example.tasktrackerspring.adapter.out.persistence;

import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.service.Description;
import com.example.tasktrackerspring.application.domain.service.Status;
import com.example.tasktrackerspring.application.domain.service.TaskID;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class TaskMapperTest {

    @Test
    public void canMapToDomainEntity() {
        TaskJsonEntity taskJsonEntity = new TaskJsonEntity();
        taskJsonEntity.setTaskId("1");
        taskJsonEntity.setDescription("description");
        taskJsonEntity.setStatus("TODO");
        taskJsonEntity.setCreatedAt("2024-12-10T21:21:00");
        taskJsonEntity.setUpdatedAt("2024-12-10T21:21:00");
        TaskMapper sut = new TaskMapper();

        Task task = sut.mapToDomainEntity(taskJsonEntity);

        assertNotNull(task);
    }

    @Test
    public void canMapToJsonEntity() {
        Task task = new Task(
                new TaskID(1),
                new Description("description"),
                Status.TODO,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        TaskMapper sut = new TaskMapper();

        TaskJsonEntity taskJsonEntity = sut.mapToJsonEntity(task);

        assertNotNull(taskJsonEntity);
    }

    @Test
    public void canMapToJsonEntityList() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(
                new TaskID(1),
                new Description("description"),
                Status.TODO,
                LocalDateTime.now(),
                LocalDateTime.now()
        ));
        tasks.add(new Task(
                new TaskID(2),
                new Description("description"),
                Status.TODO,
                LocalDateTime.now(),
                LocalDateTime.now()
        ));

        TaskMapper sut = new TaskMapper();

        List<TaskJsonEntity> taskJsonEntities = sut.mapToJsonEntityList(tasks);

        assertEquals(2, taskJsonEntities.size());
    }
}