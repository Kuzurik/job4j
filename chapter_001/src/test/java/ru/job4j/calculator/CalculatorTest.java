package ru.job4j.calculator;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */


public class CalculatorTest {

    /**
     * Test Add
     */

    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test Subtract
     */

    @Test
    public void whenSubtractOneMinusOneThenZero() {
        Calculator calc = new Calculator();
        double result = calc.subtract(1D, 1D);
        double expected = 0D;
        assertThat(result, is(expected));

    }

    /**
     * Test Div
     */


    @Test
    public void whenDivOneShareOneThenOne() {
        Calculator calc = new Calculator();
        double result = calc.div(1D, 1D);
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test Multiple
     */

    @Test
    public void whenMultipleOneMultiplyOneThenOne() {
        Calculator calc = new Calculator();
        double result = calc.multiple(1D, 1D);
        double expected = 1D;
        assertThat(result, is(expected));



    }


}
