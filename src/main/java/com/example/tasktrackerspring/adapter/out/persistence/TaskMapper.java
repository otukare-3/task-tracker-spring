package com.example.tasktrackerspring.adapter.out.persistence;

import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.service.Description;
import com.example.tasktrackerspring.application.domain.service.Status;

import java.time.LocalDateTime;
import java.util.UUID;

public class TaskMapper {
    Task mapToDomainEntity(TaskJsonEntity taskJsonEntity) {
        return new Task(
                UUID.fromString(taskJsonEntity.getTaskId()),
                new Description(taskJsonEntity.getDescription()),
                Status.valueOf(taskJsonEntity.getStatus()),
                LocalDateTime.parse(taskJsonEntity.getCreatedAt()),
                LocalDateTime.parse(taskJsonEntity.getUpdatedAt())
        );
    }
}
