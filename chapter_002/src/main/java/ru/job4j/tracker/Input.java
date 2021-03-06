package ru.job4j.tracker;

import java.util.List;

/**
 * Interface method ask.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public interface Input {

    String ask(String question);

    int ask(String question, List<Integer> range);
    
}
