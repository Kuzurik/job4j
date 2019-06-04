package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Max number test
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class MaxTest {

    /**
     * first test
     */

    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     *  second test
     */

    @Test
    public void whenMax4To3Then4() {
        Max max = new Max();
        int result = max.max(4, 3);
        assertThat(result, is(4));
    }

    /**
     * third
     */

    @Test
    public void whenMax10To15Then4() {
        Max max = new Max();
        int result = max.max(10, 15);
        assertThat(result, is(15));
    }

    /**
     * fourth test
     */

    @Test
    public void whenMax6To6Then6() {
        Max max = new Max();
        int result = max.max(6, 6);
        assertThat(result, is(6));
    }
}