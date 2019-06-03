package ru.job4j.condition;

/**
 * Stupid bot
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class DummyBot {

    /**
     * Ask a question
     * @param question bot
     * @return answer
     */

    public String answer(String question) {
        String rsl;

        if ("Hello, Bot.".equals(question)) {
            rsl = "Hello, Wiseacre.";
        } else if ("Goodbye.".equals(question)) {
            rsl = "See you soon.";
        } else {
            rsl = "It baffles me. Ask another question.";
        }


        return rsl;
    }



}
