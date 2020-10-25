package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * Main class for tracker
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class StartUI {
    private boolean exit = true;

    public void init(Input input, Store tracker, UserAction[] actions, Consumer<String> output) throws SQLException {
     List<Integer> range = new ArrayList<>();
     for(int i = 0; i != actions.length; i++) {
         range.add(i);
     }
        do {
            this.showMenu(actions);
            int select = input.ask("select: ", range);
            UserAction action = actions[select];
            action.execute(input, tracker, output);
        } while (exit);
    }

    public void showMenu(UserAction[] actions) {
        for (UserAction value : actions) {
            System.out.println(value.info());
        }
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public static void main(String[] args) {
        Input validate = new ValidateInput(
                new ConsoleInput()
        );
        try (Store tracker = new SqlTracker()) {
            StartUI ui = new StartUI();
            tracker.init();
            UserAction[] actions = {
                    new AddItem(0, "Add the new item"),
                    new ShowAll(1, "Show all items"),
                    new EditItem(2, "Edit item"),
                    new DeleteItem(3, "Delete item"),
                    new FindItemById(4, "Find item by id"),
                    new FindItemByName(5, "Find item by name"),
                    new Exit(ui, 6, "Exit program")
            };
            ui.init(validate, tracker, actions, System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
