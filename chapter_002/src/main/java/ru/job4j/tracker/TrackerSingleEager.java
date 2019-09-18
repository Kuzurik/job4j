package ru.job4j.tracker;

public class TrackerSingleEager {
    private final static TrackerSingleEager INSTANCE = new TrackerSingleEager();


    private TrackerSingleEager() {}

    public static TrackerSingleEager getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }
}
