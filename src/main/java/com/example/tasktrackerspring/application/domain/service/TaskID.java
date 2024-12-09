package com.example.tasktrackerspring.application.domain.service;

import java.util.Objects;
import java.util.UUID;

//TODO: UUID -> Integerに変更する
public record TaskID(UUID value) {
    public TaskID {
        if (value == null) throw new IllegalArgumentException("can not be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskID taskID = (TaskID) o;
        return Objects.equals(value, taskID.value);
    }

}
