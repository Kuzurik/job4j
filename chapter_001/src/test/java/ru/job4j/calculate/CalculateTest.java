package ru.job4j.calculate;

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

    public class CalculateTest {
    /**
    * Test echo.
    */
    @Test
        public void whenTakeNameThenThreeEchoPlusName() {
        String input = "Aliaksander Kuzura";
        String expect = "Echo, echo, echo : Aliaksander Kuzura"; 
        Calculate calc = new Calculate();
        String result = calc.echo(input);
        assertThat(result, is(expect));
 }


    }
