package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.function.Consumer;

public interface UserAction {

    int key();

    void execute(Input input, SqlTracker sqlTracker, Consumer<String> output) throws SQLException;

    String info();
}
