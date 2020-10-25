package ru.job4j.tracker.actions;

import ru.job4j.tracker.*;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

public class ShowAll extends BaseAction {
    public ShowAll(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Store sqlTracker, Consumer<String> output) throws SQLException {
        List<Item> list = sqlTracker.findAll();
        for (Item value : list) {
            output.accept(String.format("---%s---%s---%s", value.getId(), value.getName(), value.getDecs()));
        }
    }
}
