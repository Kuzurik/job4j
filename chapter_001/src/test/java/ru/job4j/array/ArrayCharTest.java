package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * checking pref for true or false.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class ArrayCharTest {

    /**
     * Check word Hello and pref He expected true
     */


    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar();
        boolean result = word.startsWith("Hello", "He");
        assertThat(result, is(true));
    }

    /**
     * Check word Hello and pref He expected false
     */

    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar();
        boolean result = word.startsWith("Hello", "Hi");
        assertThat(result, is(false));
    }
}