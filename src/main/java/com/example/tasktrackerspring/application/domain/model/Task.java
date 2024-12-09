package com.example.tasktrackerspring.application.domain.model;

import com.example.tasktrackerspring.application.domain.service.Description;

public record Task(java.util.UUID uuid, Description description,
                   com.example.tasktrackerspring.application.domain.service.Status status,
                   java.time.LocalDateTime parse, java.time.LocalDateTime parsed) {
}
