package ru.job4j.shape;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *  Test class Square.
 */

public class SquareTest {
    
    /**
    *Test method draw a class square 
    */
    
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(square.draw(),
                   is(
                        new StringBuilder()
                                    .append("++++\n")
                                    .append("+  +\n")
                                    .append("+  +\n")
                                    .append("++++\n")
                                    .toString()
            )
        );    
    }
}