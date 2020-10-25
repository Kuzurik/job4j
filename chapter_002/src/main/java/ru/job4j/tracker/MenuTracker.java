package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * Menu for tracker
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class MenuTracker {
    
    private final Input input;
    private final Store sqlTracker;
    private final Consumer<String> output;
    private final List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Store sqlTracker, Consumer<String> output) {
        this.input = input;
        this.sqlTracker = sqlTracker;
        this.output = output;
    }

    /**
     * store menu
     */

    public void fillActions(StartUI ui) {
        this.actions.add(0, new AddItem(0, "Add the new item"));
        this.actions.add(1, new ShowAll(1, "Show all items"));
        this.actions.add(2, new EditItem(2, "Edit item"));
        this.actions.add(3, new DeleteItem(3, "Delete item"));
        this.actions.add(4, new FindItemById(4, "Find item by id"));
        this.actions.add(5, new FindItemByName(5, "Find item by name"));
        this.actions.add(6, new Exit(ui, 6, "Exit program"));
    }

    /**
     * performs an action depending on the key
     * @param key
     */

    public void select(int key) throws SQLException {
        this.actions.get(key).execute(this.input, this.sqlTracker, this.output);
    }

    /**
     * show menu
     */

    public void show() {
        this.actions.forEach(i -> this.output.accept(i.info()));
    }

    
}
