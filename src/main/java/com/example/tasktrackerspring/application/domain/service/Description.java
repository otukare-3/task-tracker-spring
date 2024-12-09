package com.example.tasktrackerspring.application.domain.service;

import java.util.Objects;

public class Description {
    private final String value;

    public Description(String description) {
        this.value = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Description{" +
                "value='" + value + '\'' +
                '}';
    }
}
