package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Main class for tracker
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private boolean exit = true;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }



    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
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



    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    } 
}
