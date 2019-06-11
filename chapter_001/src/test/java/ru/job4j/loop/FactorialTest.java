package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test a program that calculates factorial.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class FactorialTest {

    /**
     * calculate factorial when range is five.
     */

    @Test
    public void whenCalculateFactorialForFiveThenOneHundredTwenty() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        assertThat(result, is(120));

    }

    /**
     * calculate factorial when range is zero.
     */

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        //напишите здесь тест, проверяющий, что факториал для числа 0 равен 1.
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        assertThat(result, is(1));
    }
}