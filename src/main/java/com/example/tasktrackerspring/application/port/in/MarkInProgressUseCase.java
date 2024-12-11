package com.example.tasktrackerspring.application.port.in;

import com.example.tasktrackerspring.application.domain.model.TaskID;

public interface MarkInProgressUseCase {
    void markInProgress(TaskID taskID);
}
