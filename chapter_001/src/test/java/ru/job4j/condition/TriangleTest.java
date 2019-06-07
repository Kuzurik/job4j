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
        // Create a triangle object.
        Triangle triangle = new Triangle();
        // Calculate the area.
        double result = triangle.area(0, 0, 0, 2, 2, 0);
        // Set the expected result.
        double expected = 2D;
        //Check the result and the expected value.
        assertThat(result, closeTo(expected, 0.1));
    }
}