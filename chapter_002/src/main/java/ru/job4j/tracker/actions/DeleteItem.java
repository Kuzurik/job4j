package ru.job4j.tracker.actions;

import ru.job4j.tracker.BaseAction;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Store;


import java.sql.SQLException;
import java.util.function.Consumer;

public class DeleteItem extends BaseAction {

    public DeleteItem(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, Store sqlTracker, Consumer<String> output) throws SQLException {
        output.accept("---------------Удаляем заявку----------------");
        String id = input.ask("Введите id заявки : ");
        boolean value = sqlTracker.delete(id);
        if (!value) {
            output.accept("Ничего не найдено!");
        } else {
            output.accept("Операция произведена успешно !");
        }
    }
}
