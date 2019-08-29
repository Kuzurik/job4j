package ru.job4j.tracker;

import java.util.Date;

/**
 * Main class for tracker
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class StartUI {
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }



    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("select: "));
            menu.select(key);
        }while (!(6 == menu.getExit()));

    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    } 
}
