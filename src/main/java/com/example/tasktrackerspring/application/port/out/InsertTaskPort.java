package com.example.tasktrackerspring.application.port.out;

import com.example.tasktrackerspring.application.domain.model.Task;

public interface InsertTaskPort {
    void insert(Task task);
}
