package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Comparison of three numbers
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class MultiMaxTest {

    /**
     * first test
     */

    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 2);
        assertThat(result, is(4));
    }

    /**
     * second test
     */

    @Test
    public void whenFirstMax() {
        MultiMax check = new MultiMax();
        int result = check.max(4, 1, 2);
        assertThat(result, is(4));
    }

    /**
     * third test
     */

    @Test
    public void whenThirdMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 2, 4);
        assertThat(result, is(4));
    }
}