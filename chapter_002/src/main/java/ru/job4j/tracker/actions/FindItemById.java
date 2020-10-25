package ru.job4j.tracker.actions;

import ru.job4j.tracker.*;


import java.sql.SQLException;
import java.util.function.Consumer;

public class FindItemById extends BaseAction {
    public FindItemById(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Store sqlTracker, Consumer<String> output) throws SQLException {
        output.accept("---------------Ищем по id-------------");
        String id = input.ask("Введите id : ");
        Item value = sqlTracker.findById(id);
        output.accept(String.format("---%s---%s---%s", value.getId(), value.getName(), value.getDecs()));
    }
}
