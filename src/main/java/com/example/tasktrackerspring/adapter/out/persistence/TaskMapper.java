package com.example.tasktrackerspring.adapter.out.persistence;

import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.service.Description;
import com.example.tasktrackerspring.application.domain.service.Status;
import com.example.tasktrackerspring.application.domain.service.TaskID;

import java.time.LocalDateTime;
import java.util.List;

public class TaskMapper {
    public Task mapToDomainEntity(TaskJsonEntity taskJsonEntity) {
        return new Task(
                new TaskID(Integer.parseInt(taskJsonEntity.getTaskId())),
                new Description(taskJsonEntity.getDescription()),
                Status.valueOf(taskJsonEntity.getStatus()),
                LocalDateTime.parse(taskJsonEntity.getCreatedAt()),
                LocalDateTime.parse(taskJsonEntity.getUpdatedAt())
        );
    }

    public TaskJsonEntity mapToJsonEntity(Task task) {
        TaskJsonEntity taskJsonEntity = new TaskJsonEntity();
        taskJsonEntity.setTaskId(task.id().value().toString());
        taskJsonEntity.setDescription(task.description().getValue());
        taskJsonEntity.setStatus(task.status().toString());
        taskJsonEntity.setCreatedAt(task.createdAt().toString());
        taskJsonEntity.setUpdatedAt(task.updatedAt().toString());
        return taskJsonEntity;
    }

    public List<TaskJsonEntity> mapToJsonEntityList(List<Task> tasks) {
        return tasks.stream().map(this::mapToJsonEntity).toList();
    }
}
