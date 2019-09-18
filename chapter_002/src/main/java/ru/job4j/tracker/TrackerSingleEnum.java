package ru.job4j.tracker;

public enum  TrackerSingleEnum {
    INSTANCE;

    public Item add(Item model) {
        return model;
    }
}
