package com.example.tasktrackerspring.adapter.out.persistence;

import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.service.Description;
import com.example.tasktrackerspring.application.domain.service.Status;
import com.example.tasktrackerspring.application.domain.service.TaskID;

import java.time.LocalDateTime;

public class TaskMapper {
    Task mapToDomainEntity(TaskJsonEntity taskJsonEntity) {
        return new Task(
                new TaskID(Integer.parseInt(taskJsonEntity.getTaskId())),
                new Description(taskJsonEntity.getDescription()),
                Status.valueOf(taskJsonEntity.getStatus()),
                LocalDateTime.parse(taskJsonEntity.getCreatedAt()),
                LocalDateTime.parse(taskJsonEntity.getUpdatedAt())
        );
    }
}
