package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Stupid bot test
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class DummyBotTest {

    /**
     * Test firs question
     */

    @Test
    public void whenGreetBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Hello, Bot."),
                is("Hello, Wiseacre.")
        );
    }

    /**
     * Test second question
     */

    @Test
    public void whenByeBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("Goodbye."),
                is("See you soon.")
        );
    }

    /**
     * Test third question
     */

    @Test
    public void whenUnknownBot() {
        DummyBot bot = new DummyBot();
        assertThat(
                bot.answer("How many will be 2 + 2?"),
                is("It baffles me. Ask another question.")
        );
    }

}
