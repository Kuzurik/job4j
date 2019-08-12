package ru.job4j.shape;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *  Test class Triangle.
 */

public class TriangleTest {
	
	/**
    *Test method draw a class Triangle. 
    */
	
	@Test
	public void whenDrawTriangle() {
		Triangle triangle = new Triangle();
		assertThat(triangle.draw(),
				   is(
					   new StringBuilder()
					   			.append("+")
					   			.append("+")
					   			.append("+")
					   			.append("++++")
					   			.toString()
			)
		);
	}
}