package com.example.tasktrackerspring.application.port.in;

import com.example.tasktrackerspring.application.domain.model.Task;

import java.util.List;

public interface ListTaskUseCase {

    List<Task> list();

}
