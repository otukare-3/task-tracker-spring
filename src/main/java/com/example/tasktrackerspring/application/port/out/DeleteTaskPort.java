package com.example.tasktrackerspring.application.port.out;

import com.example.tasktrackerspring.application.domain.model.TaskID;

public interface DeleteTaskPort {
    void delete(TaskID taskID);
}
