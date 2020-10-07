package ru.job4j.tracker;

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
    private final Input input;
    private final SqlTracker sqlTracker;
    private final Consumer<String> output;
    private boolean exit = true;

    public StartUI(Input input, SqlTracker sqlTracker, Consumer<String> output) {
        this.input = input;
        this.sqlTracker = sqlTracker;
        this.output = output;
    }



    public void init() throws SQLException {
        MenuTracker menu = new MenuTracker(this.input, this.sqlTracker, this.output);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i != menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
           menu.show();
            menu.select(input.ask("select: ", range));
           } while (exit);

    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }



    public static void main(String[] args) throws SQLException {
        SqlTracker sqlTracker = new SqlTracker();
        sqlTracker.init();
        new StartUI(new ValidateInput(new ConsoleInput()), sqlTracker, System.out::println).init();
        sqlTracker.close();
      /*  Input validate = new ValidateInput(
                new ConsoleInput()
        );
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            UserAction[] actions = {
                    new CreateAction()
            };
            new StartUI().init(validate, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    } 
}
