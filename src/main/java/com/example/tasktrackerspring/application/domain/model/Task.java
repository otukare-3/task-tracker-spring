package com.example.tasktrackerspring.application.domain.model;

import com.example.tasktrackerspring.application.domain.service.Description;
import com.example.tasktrackerspring.application.domain.service.Status;
import com.example.tasktrackerspring.application.domain.service.TaskID;

import java.time.LocalDateTime;

public record Task(
        TaskID id,
        Description description,
        Status status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
