package com.example.tasktrackerspring.application.port.out;

import com.example.tasktrackerspring.application.domain.model.Task;
import com.example.tasktrackerspring.application.domain.service.TaskID;

public interface LoadTaskPort {
    Task find(TaskID taskID);
}
