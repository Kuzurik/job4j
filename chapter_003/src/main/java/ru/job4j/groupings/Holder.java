package ru.job4j.groupings;

import java.util.Objects;

public class Holder {
    private String unit, name;

    public Holder(String unit, String name) {
        this.unit = unit;
        this.name = name;
    }

    public String getUnit() {
        return this.unit;
    }

    public String getName() {
        return this.name;
    }
}
