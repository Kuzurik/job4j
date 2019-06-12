package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test build a chessboard in pseudo chart.
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class BoardTest {

    /**
     * first test wight 3 and height 3
     */

    @Test
        public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
            Board board = new Board();
            String result = board.paint(3, 3);
            final String line = System.getProperty("line.separator");
            String expected = String.format("x x%s x %sx x%s", line, line, line);
            assertThat(result, is(expected));
    }

    /**
     * second test wight 5 height 4
     */

    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String result = board.paint(5, 4);
        final String line = System.getProperty("line.separator");
        String expected = String.format("x x x%s x x %sx x x%s x x %s", line, line, line, line);
        assertThat(result, is(expected));
    }
}