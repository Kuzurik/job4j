package ru.job4j.shape;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *  Tests class Paint with classes Square and Triangle.
 */

public class PaintTest {
    
    /**
    *Test class Paint with class Square. 
    */
    
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(new StringBuilder()
                            .append("++++")
                            .append("+  +")
                            .append("+  +")
                            .append("++++")
                            .append(System.lineSeparator())
                            .toString()
                )
        );
        System.setOut(stdout);    
    }
    
    /**
    *Test class Paint with class Triangle. 
    */
    
    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(new StringBuilder()
                            .append("+")
                            .append("+")
                            .append("+")
                            .append("++++")
                            .append(System.lineSeparator())
                            .toString()
            )
        );
        System.setOut(stdout);
    }
}
