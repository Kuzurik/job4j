package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Calculates the area of ​​the triangle.
 *
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class TriangleTest {

    /**
     * Test calculates the area of ​​the triangle.
     */

    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);

        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area(a, b, c);
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }
}