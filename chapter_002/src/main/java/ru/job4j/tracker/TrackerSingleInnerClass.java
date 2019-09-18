package ru.job4j.tracker;

public class TrackerSingleInnerClass {
    private TrackerSingleInnerClass() {}

    public static TrackerSingleInnerClass getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSingleInnerClass INSTANCE = new TrackerSingleInnerClass();

    }
}
