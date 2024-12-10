package com.example.tasktrackerspring.application.domain.model;

import java.time.LocalDateTime;

public record Task(
        TaskID id,
        Description description,
        Status status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
