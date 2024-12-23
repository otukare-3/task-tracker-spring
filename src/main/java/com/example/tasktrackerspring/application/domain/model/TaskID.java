package com.example.tasktrackerspring.application.domain.model;

import java.util.Objects;

public record TaskID(Integer value) {
    public TaskID {
        if (value == null || value == 0) throw new IllegalArgumentException("can not be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskID taskID = (TaskID) o;
        return Objects.equals(value, taskID.value);
    }

}
