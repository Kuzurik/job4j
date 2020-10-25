package ru.job4j.tracker.actions;

import ru.job4j.tracker.*;

import java.util.function.Consumer;

public class Exit extends BaseAction {
    private final StartUI ui;

    public Exit(StartUI ui, int key, String name) {
        super(key, name);
        this.ui = ui;
    }

    public void execute(Input input, Store sqlTracker, Consumer<String> output) {
        ui.setExit(false);
    }
}
