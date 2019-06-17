package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * check matrix true or false on the diagonal
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class MatrixCheckTest {

    /**
     * first test even matrix return true
     */

    @Test
    public void whenDataMonoByTrueThenTrueEven() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, false},
                {false, true}
                };
        boolean result = check.mono(input);
        assertThat(result, is(true));
         }

    /**
     * second test even matrix return false
     */

    @Test
    public void whenDataMonoByFalseThenFalseEven() {
         MatrixCheck check = new MatrixCheck();
         boolean[][] input = new boolean[][] {
                 {true, false},
                 {true, false}
         };
         boolean result = check.mono(input);
         assertThat(result, is(false));
     }

    /**
     * third test not even return true
     */

    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * fourth test not even return false
     */

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}