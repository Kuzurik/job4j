package ru.job4j.groupings;

import java.util.Set;

public class Student {
    private String name;
    private Set<String> units;

    public Student(String name, Set<String> units) {
        this.name = name;
        this.units = units;
    }

    public Set<String> getUnits() {
        return units;
    }

    public String getName() {
        return name;
    }
}
